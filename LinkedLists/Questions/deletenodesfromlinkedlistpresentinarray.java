class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        //hitting tle if using this and making changes in the main list
        // for (int i = 0; i < nums.length; i++) {
        //     // Check if the value is at the head and remove it
        //     while (head != null && head.val == nums[i]) {
        //         head = head.next;
        //     }
            
        //     ListNode prevptr = head;
        //     ListNode ptr = head;
            
        //     // Iterate through the list and remove matching nodes
        //     while (ptr != null) {
        //         if (ptr.val == nums[i]) {
        //             prevptr.next = ptr.next;
        //         } else {
        //             prevptr = ptr;
        //         }
        //         ptr = ptr.next;
        //     }
        // }
        // return head;
        HashSet<Integer> hs = new HashSet<Integer>();
        for(var num : nums) hs.add(num);
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode curr = dummyHead,prev = dummyHead;
        while(curr!=null)
        {
            ListNode nextNode = curr.next;
            if(hs.contains(curr.val))
            {
                prev.next = nextNode;
            }
            else
            {
                prev = curr;
            }
            curr = nextNode;
        }

        return dummyHead.next;
        
    }
}

