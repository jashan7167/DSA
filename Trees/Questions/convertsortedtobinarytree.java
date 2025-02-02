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
  public TreeNode sortedArrayToBST(int[] nums) {
    int n = nums.length;
    if (n == 0) {
      return null;
    }
    if (n == 1) {
      TreeNode head = new TreeNode(nums[0]);
      return head;
    }

    TreeNode root = sortedArray(nums, 0, n - 1);
    return root;
  }

  public TreeNode sortedArray(int[] nums, int low, int high) {
    if (low > high) {
      return null;
    }
    int mid = low + (high - low) / 2;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = sortedArray(nums, low, mid - 1);
    node.right = sortedArray(nums, mid + 1, high);
    return node;
  }
}