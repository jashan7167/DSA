/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
  public TreeNode balanceBST(TreeNode root) {
    // list is a interface and arraylist is a implementation
    List<Integer> inorder = new ArrayList<>();
    inorder = inorderTraversal(root, inorder);
    TreeNode nroot = createBST(inorder, 0, inorder.size() - 1);
    return nroot;

  }

  public TreeNode createBST(List<Integer> sorted, int start, int end) {
    if (start > end) {
      return null;

    }
    int mid = (start + end) / 2;
    TreeNode node = new TreeNode(sorted.get(mid));
    node.left = createBST(sorted, start, mid - 1);
    node.right = createBST(sorted, mid + 1, end);

    return node;

  }

  public List<Integer> inorderTraversal(TreeNode root, List<Integer> inorder) {
    if (root == null) {
      return null;
    }

    inorderTraversal(root.left, inorder);
    inorder.add(root.val);
    inorderTraversal(root.right, inorder);

    return inorder;
  }
}