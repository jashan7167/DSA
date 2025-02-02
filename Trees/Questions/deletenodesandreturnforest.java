import java.util.*;

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
  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    Set<Integer> toDeleteSet = new HashSet<>();
    for (int val : to_delete) {
      toDeleteSet.add(val);
    }

    List<TreeNode> ans = new ArrayList<>();
    root = deleteNodes(root, toDeleteSet, ans);

    if (root != null) {
      ans.add(root);
    }

    return ans;
  }

  private TreeNode deleteNodes(TreeNode root, Set<Integer> toDeleteSet, List<TreeNode> ans) {
    if (root == null) {
      return null;
    }

    root.left = deleteNodes(root.left, toDeleteSet, ans);
    root.right = deleteNodes(root.right, toDeleteSet, ans);

    if (toDeleteSet.contains(root.val)) {
      if (root.left != null) {
        ans.add(root.left);
      }
      if (root.right != null) {
        ans.add(root.right);
      }
      return null; // Delete this node
    }

    return root; // Keep this node
  }
}