/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    if (k <= 1 || head == null) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;

    while (head != null) {
      ListNode tail = prev;

      for (int i = 0; i < k; i++) {
        tail = tail.next;
        if (tail == null) {
          return dummy.next;
        }
      }

      ListNode nextGroup = tail.next;

      ListNode prevNode = null;
      ListNode current = head;
      while (current != nextGroup) {
        ListNode next = current.next;
        current.next = prevNode;
        prevNode = current;
        current = next;
      }
      // tail is the last node of the previous list
      prev.next = prevNode;
      head.next = nextGroup;

      prev = head;
      head = nextGroup;

    }
    return dummy.next;

  }
}