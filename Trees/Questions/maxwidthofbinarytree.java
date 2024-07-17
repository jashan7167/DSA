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
  public int widthOfBinaryTree(TreeNode root) {
    LinkedList<pair> q = new LinkedList<>();
    int l = Integer.MIN_VALUE;

    if (root == null) {
      return 0;
    }
    q.add(new pair(root, 0));
    while (!q.isEmpty()) {
      int level = q.size();
      l = Math.max(l, (q.getLast().level - q.getFirst().level) + 1);
      for (int i = 0; i < level; i++) {
        pair el = q.removeFirst();
        if (el.root.left != null) {
          q.addLast(new pair(el.root.left, 2 * el.level + 1));
        }
        if (el.root.right != null) {
          q.addLast(new pair(el.root.right, 2 * el.level + 2));
        }
      }
    }
    return l;
  }

  class pair {
    int level;
    TreeNode root;

    public pair(TreeNode root, int level) {
      this.level = level;
      this.root = root;
    }
  }
}
