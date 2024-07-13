class Solution {
  public String reverseParentheses(String s) {
    Stack<Integer> st = new Stack<>();
    StringBuilder res = new StringBuilder();

    for (char chars : s.toCharArray()) {
      if (chars == '(') {
        st.push(res.length());
      } else if (chars == ')') {
        // pop the previous found open bracket index
        int start = st.pop();
        // reverse the substring between start to end
        String reversed = new StringBuilder(res.substring(start)).reverse().toString();
        // replace the reversed string to the result
        res.replace(start, res.length(), reversed);
      } else {
        res.append(chars);
      }
    }

    return res.toString();
  }
}