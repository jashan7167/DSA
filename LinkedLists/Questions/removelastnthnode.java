/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int l = 0;
        if(head.next==null)
        {
            head = head.next;
            return head;
        }
        ListNode temp2 = head;
        ListNode temp = head;
        while(temp!=null)
        {
            temp = temp.next;
            l++;
        }
        if(l==n)
        {
            head = head.next;
            return head;
        }
        int remove = l - n;
        for(int i = 0  ; i < remove-1;i++)
        {
            temp2 = temp2.next;
        }
        temp2.next = temp2.next.next;
        return head;
    }
}
