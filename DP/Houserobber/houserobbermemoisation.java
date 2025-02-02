package Houserobber;

class Solution {
  public int rob2(int[] nums, int ind, int[] dp) {
    if (ind == 0)
      return nums[0];
    if (ind < 0)
      return 0;
    if (dp[ind] != -1)
      return dp[ind];

    int max = Integer.MIN_VALUE;
    int pick = nums[ind] + rob2(nums, ind - 2, dp);
    int notpick = 0 + rob2(nums, ind - 1, dp);
    dp[ind] = Math.max(pick, notpick);
    return Math.max(pick, notpick);
  }

  public int rob(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, -1);
    return rob2(nums, nums.length - 1, dp);
  }
}
