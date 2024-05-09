class Solution {
  public String removeKdigits(String num, int k) {
    int size = num.length();
    if (k == size) {
      return "0";
    }
    Stack<Character> st = new Stack<>();

    int counter = 0;
    while (counter < size) {
      // whenever there's a decrease in the no's going forward what we will do is to
      // pop the previous no as we need the smallest possible no
      while (k > 0 && !st.isEmpty() && st.peek() > num.charAt(counter)) {
        st.pop();
        k--;
      }
      st.push(num.charAt(counter));
      counter++;
    }

    // edge case to handle if all the no are same then we just remove any no's
    while (k > 0) {
      st.pop();
      k--;
    }

    StringBuilder sb = new StringBuilder();
    while (!st.isEmpty()) {
      char char_current = st.pop();
      sb.append(char_current);
    }

    sb.reverse();

    while (sb.length() > 1 && sb.charAt(0) == '0') {
      sb.deleteCharAt(0);

    }
    return sb.toString();
  }
}