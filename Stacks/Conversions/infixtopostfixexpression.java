import java.util.Stack;

class infixtopostfix {
	static int prec(char c) {
		if (c == '^') {
			return 3;
		} else if (c == '/' || c == '*') {
			return 2;
		} else if (c == '+' || c == '-') {
			return 1;
		} else {
			return -1;
		}
	}

	static char associativity(char c) {
		if (c == '^') {
			return 'R';
		}
		return 'L';
	}

	static void infixtoPostfix(String s) {
		StringBuilder result = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// if the character operand

			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
				result.append(c);
			}

			// if you get a opening bracket do this
			else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					result.append(stack.pop());
				}
				stack.pop(); // Pop '('
			} else {
				while (!stack.isEmpty() && (prec(s.charAt(i)) < prec(stack.peek()) ||
						prec(s.charAt(i)) == prec(stack.peek()) &&
								associativity(s.charAt(i)) == 'L')) {
					result.append(stack.pop());
				}

				// this handles the case where the if precedemce is same then the peek is 'r' we
				// gotta push and also when precedence of charat(i) is greater than precedence
				// of charat(i)

				stack.push(c);
			}

		}

		while (!stack.isEmpty()) {
			result.append(stack.pop());
		}

		System.out.println(result);
	}

	public static void main(String[] args) {
		String exp = "a+b*(c^d-e)^(f+g*h)-i";

		infixtoPostfix(exp);
	}

}