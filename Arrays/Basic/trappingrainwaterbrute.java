class Solution {
  public int trap(int[] height) {
    int res = 0;

    for (int i = 0; i < height.length; i++) {
      int left = height[i];
      for (int j = 0; j < i; j++) {
        left = Math.max(left, height[j]);
      }
      int right = height[i];
      for (int j = height.length - 1; j > i; j--) {
        right = Math.max(right, height[j]);
      }
      res += Math.min(left, right) - height[i];
    }
    return res;
  }
}