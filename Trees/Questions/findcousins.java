// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  * int val;
//  * TreeNode left;
//  * TreeNode right;
//  * TreeNode() {}
//  * TreeNode(int val) { this.val = val; }
//  * TreeNode(int val, TreeNode left, TreeNode right) {
//  * this.val = val;
//  * this.left = left;
//  * this.right = right;
//  * }
//  * }
//  */
class Solution {
  public boolean isCousins(TreeNode root, int x, int y) {
    TreeNode xx = findNode(root, x);
    TreeNode yy = findNode(root, y);

    return ((level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy)));
  }

  public TreeNode findNode(TreeNode node, int x) {
    if (node == null) {
      return null;
    }

    if (node.val == x) {
      return node;
    }
    TreeNode n = findNode(node.left, x);
    if (n != null) {
      return n;
    }
    return findNode(node.right, x);
  }

  public boolean isSibling(TreeNode root, TreeNode xx, TreeNode yy) {
    if (root == null) {
      return false;
    }
    return ((root.left == xx && root.right == yy) || (root.left == yy && root.right == xx)
        || isSibling(root.left, xx, yy) || isSibling(root.right, xx, yy));
  }

  public int level(TreeNode root, TreeNode t, int lev) {
    if (root == null) {
      return 0;
    }
    if (root == t) {
      return lev;
    }
    int l = level(root.left, t, lev + 1);
    if (l != 0) {
      return l;
    }
    return level(root.right, t, lev + 1);
  }
}
