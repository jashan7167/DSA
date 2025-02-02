import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sortlinkedlist {
//Brute force
  // public ListNode sortList(ListNode head) {
  //   List<Integer> ls = new ArrayList<Integer>();

  //   ListNode temp = head;
  //   while (temp != null) {
  //     ls.add(temp.val);
  //     temp = temp.next;
  //   }
  //   Collections.sort(ls);
  //   temp = head;
  //   int i = 0;
  //   while (temp != null) {
  //     temp.val = ls.get(i);
  //     temp = temp.next;
  //     i++;
  //   }
  //   return head;
  // }

  //Optimal Solution
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode middle = middleNode(head);
    ListNode righthand = middle.next;
    middle.next = null;
    ListNode lefthand = head;

    lefthand = sortList(lefthand);
    righthand = sortList(righthand);

    return mergeTwoLists(lefthand, righthand);
  }

  public static ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head.next;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;

    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        current.next = list1;
        list1 = list1.next;
      } else {
        current.next = list2;
        list2 = list2.next;
      }
      current = current.next;
    }

    if (list1 != null) {
      current.next = list1;
    }

    if (list2 != null) {
      current.next = list2;
    }

    return dummy.next;
  }

  public static void main(String[] args) {

  }
}
