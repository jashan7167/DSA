public class singlylinkedlist {
  private Node head = null;
  private Node tail = null;
  private int size;

  public singlylinkedlist() {
    this.size = 0;
  }

  public Node get(int index) {
    Node node = head;
    for (int i = 1; i < index; i++) {
      node = node.next;
    }
    return node;
  }

  // find a node reference with a particular value
  public Node find(int value) {
    Node node = head;
    while (node != null) {
      if (node.value == value) {
        return node;
      }
      node = node.next;
    }

    return null;
  }

  public void insertFirst(int val) {
    // time complexity = O(n)
    Node node = new Node(val);
    node.next = head;
    head = node;

    // if there is only one item then head and tail are same
    if (tail == null) {
      tail = head;
    }

    size += 1;
  }

  public void insertatTail(int val) {

    if (tail == null) {
      insertFirst(val);
      return;
    }
    Node node = new Node(val);
    tail.next = node;
    node.next = null;
    tail = node;
    size++;
  }

  public void insert(int val, int index) {

    if (index == 0) {
      insertFirst(val);
      return;
    }
    if (index == size) {
      insertatTail(val);
      return;
    }
    Node temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.next; // this reaches to the node before the index
    }

    Node node = new Node(val, temp.next);
    temp.next = node;
    size++;
  }

  public void display() {
    Node temp;
    temp = head;
    while (temp != null) {
      if (temp.next == null) {
        System.out.print(temp.value + "->END");
      } else {
        System.out.print(temp.value + "->");
      }
      temp = temp.next;
    }
    System.out.println();
  }

  // deletions
  public int deletefirst() {
    int val = head.value;
    head = head.next;
    size--;
    if (head == null) {
      tail = null;
    }
    return val;

  }

  public int deletelast() {
    if (size <= 1) {
      return deletefirst();
    }

    Node secondLast = get(size - 1);
    int val = tail.value;
    tail = secondLast;
    size--;
    secondLast.next = null;
    return val;
    // anything after return is an unreachable code
  }

  public int deleteparticularindex(int index) {
    if (index == 1) {
      return deletefirst();
    }
    if (index == size) {
      return deletelast();
    }
    Node temp = get(index - 1);
    Node target = temp.next;
    int val = target.value;
    temp.next = target.next;
    target.next = null;
    return val;
  }

  private class Node {
    private int value;
    private Node next;

    public Node(int value) {
      this.value = value;
    }

    public Node(int value, Node next) {
      this.value = value;
      this.next = next;
    }
  }
//recursive solution of reversal
  // private Node reverse(Node node) {
  //   if (head == null || head.next == null) {
  //     return head;
  //   }
  //   Node reversed = reverse(head.next);
  //   head.next.next = head;
  //   head.next = null;
  //   return reversed;
  // }

  private void reverseIterative(Node node) {
    if(size<2)
    {
      return;
    }
    Node prev = null;
    Node pres = node;
    Node next = pres.next;
    while (pres != null) {
      pres.next = prev;
      prev = pres;
      pres = next;
      if(next!=null)
      {
        next = next.next;
      }
    }
    head = prev;
  }

  public static void main(String[] args) {

    singlylinkedlist ll = new singlylinkedlist();
    // ll.insertFirst(1);
    // ll.insertFirst(2);
    // ll.insertFirst(3);
    // ll.insertFirst(4);
    ll.insertatTail(1);
    ll.insertatTail(2);
    ll.insertatTail(3);
    ll.insertatTail(4);
    ll.insertatTail(5);
    ll.insertatTail(6);
    ll.insertatTail(7);
    ll.insertatTail(8);

    ll.insert(22, 1);
    System.out.println(ll.size);
    ll.display();
    System.out.println("Deleted Node Value: " + ll.deletefirst());
    ll.display();
    System.out.println(ll.size);
    System.out.println("Last node remove" + ll.deletelast());
    ll.display();
    System.out.println("deleting node at index 4: " + ll.deleteparticularindex(4));
    // ll.reverse(ll.get(1));
    ll.display();
    ll.reverseIterative(ll.get(2));
    ll.display();

  }
}