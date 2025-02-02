

public class linkedlistcycle {
  
  public boolean hasCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    if (head == null) {
      return false;
    }
    if (head.next == null) {
      return false;
    }
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        return true;
      }
    }
    int count = 1;
    if (fast == slow) {
      slow = slow.next; // intially we have to move it by 1 otherwise the loop will not run as they are
                        // initially equal
      while (slow != fast) {
        slow = slow.next;
        count++;
      }
    }
    System.out.print(count);
    return false;
  }

  public static void main(String[] args) {

  }
}
