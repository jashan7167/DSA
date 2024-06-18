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
  public int maxPathSum(TreeNode root) {
    sumNumbers2(root);
    return maxsum;

  }

  int maxsum = Integer.MIN_VALUE;

  public int sumNumbers2(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = sumNumbers2(root.left);
    int right = sumNumbers2(root.right);
    left = Math.max(0, left);
    right = Math.max(0, right);
    int max = left + right + rootk.val;
    maxsum = Math.max(maxsum, max);
    return Math.max(left, right) + root.val;

  }

}
