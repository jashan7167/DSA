import java.util.* ;
import java.io.*; 
/*************************************************************

Following is the class structure of the Node class:

    class Node {
		public int data;
		public Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
	  	}
    }

*************************************************************/

public class Solution {
	public static Node reverse(Node head)
	{
		Node prev = null;
		Node current = head;
		Node next =  null;
		while(current!=null)
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
	public static Node addOne(Node head) {

				Node nhead = reverse(head);
				Node temp2 = nhead;
				Node dummy = new Node(0);
				Node temp = dummy;
				int carry=1;
				int sum = 0;
				while(temp2!=null)
				{
					sum = temp2.data + carry;
					carry = sum/10;
					sum = sum%10;
					Node newnode = new Node(sum);
					temp.next = newnode;
					temp = temp.next;
					temp2 = temp2.next;
				}
				if(carry!=0)
				{
					Node newnode = new Node(carry);
					temp.next = newnode;
				}
				return reverse(dummy.next);
				
	}
}