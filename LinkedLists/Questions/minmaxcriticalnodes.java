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
  public int[] nodesBetweenCriticalPoints(ListNode head) {
    ListNode ptr = head.next;
    ListNode preptr = head;
    List<Integer> ls = new ArrayList<Integer>();
    int count = 1;
    while (ptr.next != null) {
      // local max
      if (preptr.val < ptr.val && ptr.next.val < ptr.val) {
        ls.add(count);
      } else if (preptr.val > ptr.val && ptr.next.val > ptr.val) {
        ls.add(count);
      }
      preptr = ptr;
      ptr = ptr.next;
      count++;
    }
    if (ls.size() >= 2) {
      int min = Integer.MAX_VALUE;
      int i = 0;
      for (i = 0; i < ls.size() - 2; i++) {
        min = Math.min(min, ls.get(i + 1) - ls.get(i));
      }
      min = Math.min(min, ls.get(ls.size() - 1) - ls.get(ls.size() - 2));

      return new int[] { min, ls.get(ls.size() - 1) - ls.get(0)
      };

    } else {
      return new int[] { -1, -1 };
    }

  }
}