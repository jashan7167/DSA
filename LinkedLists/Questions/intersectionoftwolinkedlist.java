/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int l1 = 0;
        int l2 = 0;
        while(temp1!=null)
        {
            temp1 = temp1.next;
            l1++;
        }
        while(temp2!=null)
        {
            temp2 = temp2.next;
            l2++;
        }

        if(l1==1 && l2==1)
        {
            if(headA==headB)
            {
                return headA;
            }
            else if(headA.next == headB)
            {
                return headB;
            }
            else if(headB.next == headA)
            {
                return headA;
            }
            else
            {
                return null;
            }
        }

        ListNode temp3 = headA;
        ListNode temp4 = headB;
        if(l1>l2)
        {
            for(int i = 0 ; i < l1-l2 ; i++)
            {
                temp3 = temp3.next;
            }
        }
        else
        {
             for(int i = 0 ; i < l2-l1 ; i++)
            {
                temp4 = temp4.next;
            }
            
        }
        while(temp3!=null || temp4!=null)
        {
            if(temp3 == temp4)
            {
                return temp3;
            }
            temp3 = temp3.next;
            temp4 = temp4.next;
        }
        return null;
       
    }
}