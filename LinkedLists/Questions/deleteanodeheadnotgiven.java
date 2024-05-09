/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public void deleteNode(ListNode node) {
    ListNode next = node.next;
    int valnext = next.val;
    node.val = valnext;
    node.next = next.next;

  }
}