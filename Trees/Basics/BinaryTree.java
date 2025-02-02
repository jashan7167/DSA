import java.util.Scanner;
import java.util.*;

class BinaryTree {
  public BinaryTree() {

  }

  private static class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
      this.value = value;
    }
  }

  private Node root;

  Stack<Node> st = new Stack<>();

  // insert elements

  public void populate(Scanner scanner) {
    System.out.println("Enter the root Node:");
    int value = scanner.nextInt();
    root = new Node(value);
    populate(scanner, root);
  }
  // what happens is that you pass the root value into the populate and then
  // recursive calls for left and right happens
  // you passed the root prompt to enter the left of the root is done if you want
  // the function is called again on that node and asks you want to enter left if
  // you dont it comes out of there and goes to the right block and asks you want
  // to add right lets say we dont it goes to the root again and continues from
  // the left block and asks you want to insert right

  private void populate(Scanner scanner, Node node) {
    System.out.println("Do you want to enter left of " + node.value);
    boolean left = scanner.nextBoolean();
    if (left) {
      System.out.println("Enter the value of the left of " + node.value);
      int value = scanner.nextInt();
      node.left = new Node(value);
      populate(scanner, node.left);
    }

    System.out.println("Do you want to enter right of " + node.value);
    boolean right = scanner.nextBoolean();
    if (right) {
      System.out.println("Enter the value of the right of " + node.value);
      int value = scanner.nextInt();
      node.right = new Node(value);
      populate(scanner, node.right);
    }
  }

  public void display() {
    display(root, " ");
  }

  private void display(Node node, String indent) {
    if (node == null) {
      return;
    }
    System.out.println(node.left + indent);
    display(node.left, indent + "\t");
    display(node.right, indent + "\t");
  }

  public void prettydisplay() {
    prettydisplay(root, 0);
  }



 

  public void prettydisplay(Node node, int level) {
    if (node == null) {
      return;
    }
    prettydisplay(node.right, level + 1);

    if (level != 0) {
      for (int i = 0; i < level - 1; i++) {
        System.out.print("|\t\t");
      }
      System.out.println("|------->" + node.value);
    } else {
      System.out.println(node.value);
    }

    prettydisplay(node.left, level + 1);

  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    BinaryTree tree = new BinaryTree();
    tree.populate(scanner);
    tree.prettydisplay();
  }
}