class Solution {
  public ListNode removeNodes(ListNode head) {
    ListNode curr = head;
    Stack<Integer> st = new Stack<>();

    while (curr != null) {
      while (!st.isEmpty() && curr.val > st.peek()) {
        st.pop();
      }
      st.push(curr.val);
      curr = curr.next;
    }

    ListNode current = null;
    while (!st.isEmpty()) {
      ListNode temp = new ListNode(st.pop());
      temp.next = current;
      current = temp;
    }

    return current;
  }
}
