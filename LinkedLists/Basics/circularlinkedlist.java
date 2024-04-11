class circularlinkedlist {
  Node head;
  Node tail;
  int size = 0;

  public void insertFirst(int val) {
    Node newNode = new Node(val);
    if (head == null) {
      newNode.next = null;
      head = tail = newNode;
      size++;
    } else {
      tail.next = newNode;
      newNode.next = head;
      tail = newNode;
      size++;
    }
  }

  public void delete(int val) {
    Node node = head;
    if (node == null) {
      return;
    }
    if (node.value == val) {
      head = head.next;
      tail.next = head;
      return;
    }
    Node prev;
    do {
      prev = node;
      node = node.next;
    } while (node.value != val);

    prev.next = node.next;
  }

  public void display() {
    Node temp = head;
    do {
      System.out.print(temp.value + "->");
      temp = temp.next;
    } while (temp != head);

    System.out.println("END");
  }

  private class Node {
    int value;
    Node next;

    Node(int v) {
      this.value = v;
    }

    Node(int v, Node next) {
      this.value = v;
      this.next = next;
    }
  }

  public static void main(String[] args) {
    circularlinkedlist cl = new circularlinkedlist();
    cl.insertFirst(1);
    cl.insertFirst(2);
    cl.insertFirst(3);
    cl.insertFirst(4);
    cl.delete(3);
    cl.display();
  }
}