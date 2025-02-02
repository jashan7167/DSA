public class doublylinkedlist {

  Node head;

  public Node get(int index) {
    Node temp = head;
    for (int i = 1; i < index; i++) {
      temp = temp.next;
    }
    return temp;
  }

  public Node find(int value) {
    Node node = head;
    while (node != null) {
      if (node.val == value) {
        return node;
      }
      node = node.next;
    }
    return node;
  }

  public void insertFirst(int val) {
    Node node = new Node(val);
    node.next = head;
    node.prev = null;
    if (head != null) {
      head.prev = node;
    }
    head = node;
  }

  public void insertEnd(int val) {
    Node node = head;
    Node newnode = new Node(val);
    if (head == null) {
      newnode.next = null;
      newnode.prev = null;
      head = newnode;
      return;
    }
    while (node.next != null) {
      node = node.next;
    }
    newnode.next = null;
    newnode.prev = node;
    node.next = newnode;
  }

  public void insertaftervalue(int after, int val) {
    Node target = find(after);
    Node newnode = new Node(13);
    newnode.next = target.next;
    newnode.prev = target;
    if(target.next!=null)
    {
      target.next.prev = newnode;
    }
    target.next = newnode;
  }

  public void display() {
    Node node = head;
    Node last = null;
    while (node != null) {
      System.out.print(node.val + "->");
      last = node;
      node = node.next;
    }
    System.out.println("END");

    System.out.println("Displaying in reverse");
    while (last != null) {
      System.out.print(last.val + "->");
      last = last.prev;
    }

    System.out.println("START");
  }

  private class Node {
    private int val;
    private Node next;
    private Node prev;

    Node(int val) {
      this.val = val;
    }

    Node(int val, Node next, Node prev) {
      this.val = val;
      this.next = next;
      this.prev = prev;
    }
  }

  public static void main(String[] args) {

    doublylinkedlist dll = new doublylinkedlist();
    dll.insertFirst(1);
    dll.insertFirst(2);
    dll.insertFirst(3);
    dll.insertFirst(4);
    dll.insertFirst(5);
    // dll.display();
    System.out.println("Inserting at the end: ");
    dll.insertEnd(7);
    // dll.display();
    System.out.println("Inserting after a value: ");
    dll.insertaftervalue(4, 13);
    dll.display();
  }
}
