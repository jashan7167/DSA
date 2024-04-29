import java.util.Stack;

class Solution {
  public int minInsertions(String s) {
    Stack<Character> st = new Stack<Character>();
    char[] arr = s.toCharArray();
    int insertions = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == '(') {
        st.push(arr[i]);
      } else {
        if (st.isEmpty() || st.peek() != '(') {
          insertions++;
        } else {
          st.pop();
        }
        if (i + 1 < arr.length && arr[i + 1] == ')') {
          i = i + 1;
        } else {
          insertions++;
        }
      }
    }

    insertions = insertions + st.size() * 2;
    return insertions;
  }
}