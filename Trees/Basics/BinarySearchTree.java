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
    BinarySearchTree tree = new BinarySearchTree();
    int[] nums = { 5, 2, 7, 1, 4, 6, 9, 8, 4, 10 };
    tree.populate(nums);
    tree.display();

  }

}
