import java.util.Stack;

class Solution {
  public int minAddToMakeValid(String s) {
    Stack<Character> st = new Stack<Character>();
    for (char c : s.toCharArray()) {
      if (c == ')') {
        if (!st.isEmpty() && st.peek() == '(') {
          st.pop();
        } else {
          st.push(c);
        }
      } else {
        st.push(c);
      }
    }

    return st.size();
  }

}