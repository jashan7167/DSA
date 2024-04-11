

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
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode head1 = list1;
    ListNode head2 = list2;
    ListNode list3 = new ListNode();
    ListNode temp = new ListNode();
    temp = list3;

    while (head1 != null && head2 != null) {
      if (head1.val < head2.val) {
        ListNode newnode = new ListNode(head1.val, null);
        if (list3 == null) {

          list3 = newnode;
          temp = newnode;
        } else {
          temp.next = newnode;
          temp = newnode;
        }
        head1 = head1.next;
      } else {
        ListNode newnode = new ListNode(head2.val, null);
        if (list3 == null) {
          list3 = newnode;
          temp = newnode;
        } else {
          temp.next = newnode;
          temp = newnode;
        }
        head2 = head2.next;
      }

    }
    while (head1 != null) {
      ListNode newnode = new ListNode(head1.val, null);
      temp.next = newnode;
      temp = newnode;
      head1 = head1.next;
    }

    while (head2 != null) {
      ListNode newnode = new ListNode(head2.val, null);
      temp.next = newnode;
      temp = newnode;
      head2 = head2.next;
    }
    ListNode head3 = list3.next;
    return head3;
  }
}