public class AVL {

  public class Node {
    private int value;
    private int height;
    private Node left;
    private Node right;

    public Node(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }
  }

  private Node root;

  public int height(Node node) {
    if (node == null) {
      return -1;
    }
    return node.height;
  }

  public boolean isEmpty() {
    return root == null;
  }

  public void display() {
    display(root, "Root Node: ");
  }

  public void display(Node node, String details) {
    if (node == null) {
      return;
    }
    System.out.println(details + node.value);

    display(node.left, "Left Child of " + node.getValue() + " ");
    display(node.right, "Right Child of " + node.getValue() + " ");
  }

  public void insert(int value) {
    // the first one returns root which is set as root always hence we dont need to
    // explicitally decide the root node

    root = insert(value, root);

  }

  public Node insert(int value, Node node) {
    if (node == null) {
      node = new Node(value);
      return node;
    }

    if (value < node.value) {
      node.left = insert(value, node.left);
    }

    if (value > node.value) {
      node.right = insert(value, node.right);
    }

    node.height = Math.max(height(node.left), height(node.right)) + 1;
    // while inserting the nodes at each return phase the rotate function will be
    // called and search for unbalanced node when it finds it the rotation happens
    return rotate(node);
  }

  // as thought it is called for each an every node as we move above it will be
  // satisfied only once in other cases just return node itself
  public Node rotate(Node node) {
    if (height(node.left) - height(node.right) > 1) {
      System.out.println("left heavy" + node.value);
      // left heavy
      if (height(node.left.left) - height(node.left.right) > 0) {
        // left left case

        return rightRotate(node);
      }
      if (height(node.left.left) - height(node.left.right) < 0) {
        // left right case
        node.left = leftRotate(node.left);
        return rightRotate(node);
      }
    }
    if (height(node.left) - height(node.right) < -1) {
      // right heavy
      System.out.println("right heavy" + node.value);
      if (height(node.right.left) - height(node.right.right) < 0) {
        // right right case

        return leftRotate(node);
      }
      if (height(node.right.left) - height(node.right.right) > 0) {
        // right left case
        node.right = rightRotate(node.right);
        return leftRotate(node);
      }
    }
    return node;
  }

  public Node rightRotate(Node p) {
    Node c = p.left;
    Node t = c.right;
    c.right = p;
    p.left = t;
    p.height = Math.max(height(p.left), height(p.right));
    c.height = Math.max(height(c.left), height(c.right));

    return c;
  }

  public Node leftRotate(Node c) {
    Node p = c.right;
    Node t = p.left;
    p.left = c;
    c.right = t;
    p.height = Math.max(height(p.left), height(p.right));
    c.height = Math.max(height(c.left), height(c.right));

    return p;

  }

  public void populateSorted(int[] nums) {
    populateSorted(nums, 0, nums.length);
  }

  public void populateSorted(int[] sorted, int start, int end) {
    if (start >= end) {
      return;
    }
    // nice chalgya
    int mid = (start + end) / 2;
    insert(sorted[mid]);
    populateSorted(sorted, start, mid - 1);
    populateSorted(sorted, mid + 1, end);
  }

  public boolean balance() {
    return balanced(root);
  }

  private boolean balanced(Node node) {
    if (node == null) {
      return true;
    }

    return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
  }

  public void populate(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      this.insert(nums[i]);
    }
  }

  public static void main(String[] args) {
    AVL tree = new AVL();
    int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    tree.populate(nums);
    tree.display();
    System.out.println(tree.height(tree.root));

  }

}
