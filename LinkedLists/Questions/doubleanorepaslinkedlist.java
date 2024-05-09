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
  public ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode next = null;
    ListNode curr = head;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  public ListNode doubleIt(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode revhead = reverse(head);
    ListNode temp = revhead;
    ListNode prev = null;

    int carry = 0;
    while (temp != null) {
      int value = temp.val * 2 + carry;
      int digit = value % 10;
      carry = value / 10;
      temp.val = digit;
      prev = temp;
      temp = temp.next;
    }
    if (carry != 0) {
      ListNode newnode = new ListNode(carry);
      prev.next = newnode;
    }

    return reverse(revhead);

  }
}