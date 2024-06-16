public class BinarySearchTree {

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
    // if value is smaller than the value in node then traverse to left and compare
    if (value < node.value) {
      node.left = insert(value, node.left);
    }
    // if value is greater than value in node the traverse to right and compare
    if (value > node.value) {
      node.right = insert(value, node.right);
    }
    // while backtracking adjust the height of the nodes as new node is added they
    // have to be changed
    node.height = Math.max(height(node.left), height(node.right)) + 1;
    // if its not null then the same node is returned that will be no change
    return node;
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

  public void postOrder(Node node) {
    if (node == null) {
      return;
    }

    postOrder(node.left);
    postOrder(node.right);
    System.out.println(node.value);
  }

  public void preOrder(Node node) {
    if (node == null) {
      return;
    }

    System.out.println(node.value);
    preOrder(node.left);
    preOrder(node.right);
  }

  public void inOrder(Node node) {
    if (node == null) {
      return;
    }

    inOrder(node.left);
    System.out.println(node.value);
    inOrder(node.right);
  }

  public boolean findVal(Node root, int val) {
    if (root == null) // if it goes to null finding the node obviously it doesnot exist then
    {
      return false;
    }
    if (root.value == val) // found the node return true value
    {
      return true;
    }
    if (val > root.value) {
      return findVal(root.right, val);
    } else {
      return findVal(root.left, val);
    }

  }

  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();
    int[] nums = { 5, 2, 7, 1, 4, 6, 9, 8, 4, 10 };
    tree.populate(nums);
    // int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    // tree.populateSorted(nums);
    System.out.println("Preorder");
    tree.preOrder(tree.root);
    System.out.println("PostOrder");
    tree.postOrder(tree.root);
    System.out.println("In order");
    tree.inOrder(tree.root);
    System.out.println(tree.findVal(tree.root, 11));

  }

}
