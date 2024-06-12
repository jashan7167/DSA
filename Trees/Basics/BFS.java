import java.util.*;

public class BFS {
  class Node {
    int value;
    int height;
    Node left;
    Node right;

    public Node(int value) {
      this.value = value;
    }
  }

  private Node root;

  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      // for each level the node is removed and its children are added then we again
      // calculate the level size and repeat until we reach leaf nodes
      int levelSize = queue.size();
      List<Integer> curlevel = new ArrayList<>();

      for (int i = 0; i < levelSize; i++) {
        Node currentNode = queue.poll();
        curlevel.add(currentNode.value);
        if (currentNode.left != null) {
          queue.offer(currentNode.left);
        }
        if (currentNode.right != null) {
          queue.offer(currentNode.right);
        }

      }
      result.add(curlevel);

    }

    return result;

  }

  private int height(Node node) {
    if (node == null) {
      return -1;
    }
    return node.height;
  }

  public Node findSuccessor(Node root, int key) {
    if (root == null) {
      return null;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      List<Integer> curlevel = new ArrayList<>();

      Node currentNode = queue.poll();
      curlevel.add(currentNode.value);
      if (currentNode.left != null) {
        queue.offer(currentNode.left);
      }
      if (currentNode.right != null) {
        queue.offer(currentNode.right);
      }
      if (currentNode.value == key) {
        break;
      }

    }

    return queue.peek();

  }

  private Node insert(int value, Node node) {
    if (node == null) {
      Node newnode = new Node(value);
      return newnode;
    }

    if (value > node.value) {
      node.right = insert(value, node.right);
    }
    if (value < node.value) {
      node.left = insert(value, node.left);
    }

    node.height = Math.max(height(node.left), height(node.right)) + 1;

    return node;
  }

  public void insert(int value) {
    root = insert(value, root);
  }

  public void populate(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      insert(arr[i]);
    }

  }

  public static void main(String[] args) {

    BFS tree = new BFS();
    int[] nums = { 5, 2, 7, 1, 4, 6, 9, 8, 4, 10 };
    tree.populate(nums);
    System.out.println("tree created");
    System.out.println(tree.levelOrder(tree.root));
    System.out.println(tree.findSuccessor(tree.root, 4).value);
  }
}
