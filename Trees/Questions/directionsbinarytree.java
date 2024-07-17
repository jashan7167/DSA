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
  public String getDirections(TreeNode root, int startValue, int destValue) {
    // Find paths from root to startValue and destValue
    StringBuilder startPath = new StringBuilder();
    StringBuilder destPath = new StringBuilder();

    findPath(root, startValue, new StringBuilder(), startPath);
    findPath(root, destValue, new StringBuilder(), destPath);

    // Find the common path length
    int i = 0;
    while (i < Math.min(startPath.length(), destPath.length()) && startPath.charAt(i) == destPath.charAt(i)) {
      i++;
    }

    // Remove the common prefix and adjust the start path
    StringBuilder upMoves = new StringBuilder();
    for (int j = i; j < startPath.length(); j++) {
      upMoves.append('U');
    }
    String remainingDestPath = destPath.substring(i);

    return upMoves.toString() + remainingDestPath;
  }

  private boolean findPath(TreeNode root, int targetValue, StringBuilder currentPath, StringBuilder resultPath) {
    if (root == null) {
      return false;
    }
    if (root.val == targetValue) {
      resultPath.append(currentPath);
      return true;
    }

    currentPath.append('L');
    if (findPath(root.left, targetValue, currentPath, resultPath)) {
      return true;
    }
    currentPath.setLength(currentPath.length() - 1); // backtrack

    currentPath.append('R');
    if (findPath(root.right, targetValue, currentPath, resultPath)) {
      return true;
    }
    currentPath.setLength(currentPath.length() - 1); // backtrack

    return false;
  }
}
