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
    public ListNode mergeNodes(ListNode head) {
        ListNode ptr = head.next.next;
        ListNode startNode = head.next;
        ListNode head2 = startNode;
        while(ptr.next!=null)
        {
            if(ptr.val==0)
            {
                startNode.next = ptr.next;
                startNode = ptr.next;
                ptr = ptr.next.next;
            }
            else
            {
                startNode.val+=ptr.val;
                ptr = ptr.next;  
            }
        }
        startNode.next=null;

        return head2;
    }
}