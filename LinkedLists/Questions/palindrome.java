class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class Solution {
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true; // an empty list or single node list is a palindrome
    }

    ListNode mid = middleNode(head);
    ListNode secondHalf = reverseList(mid.next);

    // Compare the first half with the reversed second half
    ListNode p1 = head;
    ListNode p2 = secondHalf;
    while (p2 != null) {
      if (p1.val != p2.val) {
        return false; // Not a palindrome
      }
      p1 = p1.next;
      p2 = p2.next;
    }

    return true; // Palindrome
  }

  public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
}
