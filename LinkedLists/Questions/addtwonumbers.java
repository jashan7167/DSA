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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode t1,t2,curr;
    t1 = l1;
    t2 = l2;
    ListNode dummy = new ListNode(-1,null);
    curr = dummy;
    int carry = 0;
    while(t1!=null || t2!=null)
    {
      int sum = 0;
      if(t1!=null)
      {
        sum+=t1.val;
      }
      if(t2!=null)
      {
        sum+=t2.val;
      }
      sum+=carry;
      carry = sum/10;
      sum = sum%10;

      ListNode newNode = new ListNode(sum);
      curr.next = newNode;
      curr = curr.next;
      if(t1!=null)
      {
        t1 = t1.next;
      }
      if(t2!=null)
      {
        t2 = t2.next;
      }
    }

    return dummy.next;
  }
}