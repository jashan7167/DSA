class RotateList {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }
    int shift;
    int length = length(head);
    k = k % length;
    if (k == 0) {
      return head;
    } else {
      shift = length - k;
      System.out.println(shift);
      ListNode temp = head;
      ListNode temp2 = head;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = head;
      // now shift the head
      for (int i = 0; i < shift; i++) {
        head = head.next;
      }
      for (int i = 0; i < shift - 1; i++) {
        temp2 = temp2.next;
      }
      temp2.next = null;
      return head;
    }
  }

  public static int length(ListNode head) {
    int length = 0;
    ListNode temp = head;
    while (temp != null) {
      temp = temp.next;
      length++;
    }
    return length;
  }

}