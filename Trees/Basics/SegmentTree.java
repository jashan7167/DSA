public class SegmentTree {

  class Node {
    private int data;
    private int startint;
    private int endint;
    Node left;
    Node right;

    public Node(int start, int end) {
      this.startint = start;
      this.endint = end;
    }
  }

  Node root;

  public SegmentTree(int[] arr) {
    // create a tree using this array
    this.root = constructTree(arr, 0, arr.length - 1);
  }

  private Node constructTree(int[] arr, int start, int end) {
    if (start == end) {
      Node leaf = new Node(start, end);
      leaf.data = arr[start];
      return leaf;
    }

    // create new node with index we are currently at
    Node node = new Node(start, end);
    int mid = (start + end) / 2;
    node.left = this.constructTree(arr, start, mid);
    node.right = this.constructTree(arr, mid + 1, end);

    node.data = node.left.data + node.right.data;
    return node;
  }

  public void display() {
    display(this.root);
  }

  private void display(Node node) {
    String str = "";

    if (node.left != null) {
      str = str + "Interval=[" + node.left.startint + "-" + node.left.endint + "] and data: " + node.left.data + "=> ";
    } else {
      str = str + "No left child ";
    }
    // for current node
    str = str + "Interval=[" + node.startint + "-" + node.endint + "] and data: " + node.data + "=> ";

    if (node.right != null) {
      str = str + "Interval=[" + node.right.startint + "-" + node.right.endint + "] and data: " + node.right.data
          + "=> ";
    } else {
      str = str + "No right child ";
    }

    System.out.println(str + "\n");

    if (node.left != null) {
      display(node.left);
    }
    if (node.right != null) {
      display(node.right);
    }

  }

  // query
  public int query(int qsi, int qei) {
    return this.query(this.root, qsi, qei);
  }

  private int query(Node node, int qsi, int qei) {
    if (node.startint >= qsi && node.endint <= qei) {
      // node lying inside query
      return node.data;
      // if the interval is not of any of our use
    } else if (node.startint > qei || node.endint < qsi) {
      return 0;
      // full overlap that we have to break the interval to find the desired ones
    } else {
      return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
    }
  }

  public void update(int index, int value) {
    this.root.data = update(this.root, index, value);
  }

  // update
  private int update(Node node, int index, int value) {
    if (index >= node.startint && index <= node.endint) {
      if (index == node.startint && index == node.endint) {
        System.out.println("Updating" + node.startint);
        node.data = value;
        return node.data;
      }
    } else {
      int leftAns = update(node.left, index, value);
      int rightAns = update(node.right, index, value);

      node.data = leftAns + rightAns;

      return node.data;
    }

    return node.data;

  }

  public static void main(String[] args) {
    int[] arr = { 3, 8, 6, 7, -2, -8, 4, 9 };
    SegmentTree st = new SegmentTree(arr);
    System.out.println("Segment Tree created.");
    System.out.println(st.query(2, 5));
    st.update(4, 10);
    st.display();
  }
}
