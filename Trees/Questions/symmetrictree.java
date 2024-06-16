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
  // we need to check that if the levels are mirror image of each other using BFS
  public boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root.left);
    queue.offer(root.right);
    while (!queue.isEmpty()) {
      TreeNode left = queue.poll();
      TreeNode right = queue.poll();

      if (left == null && right == null) {
        continue;
      }

      if (left == null || right == null) {
        return false;
      }

      if (left.val != right.val) {
        return false;
      }
      queue.offer(left.left);
      queue.offer(right.right);
      queue.offer(left.right);
      queue.offer(right.left);
    }

    return true;
  }
}