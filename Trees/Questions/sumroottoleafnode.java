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
  public int sumNumbers(TreeNode root) {
    return sumNumbers2(root, 0);

  }

  public int sumNumbers2(TreeNode root, int s) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return s * 10 + root.val;
    }

    int left = sumNumbers2(root.left, s * 10 + root.val);
    int right = sumNumbers2(root.right, s * 10 + root.val);
    return left + right;

  }
}