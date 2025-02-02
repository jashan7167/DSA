package Houserobber;

class Solution {
  public int rob2(int[] nums, int ind) {
    if (ind == 0)
      return nums[0];
    if (ind < 0)
      return 0;

    int max = Integer.MIN_VALUE;
    int pick = nums[ind] + rob2(nums, ind - 2);
    int notpick = 0 + rob2(nums, ind - 1);

    return Math.max(pick, notpick);
  }

  public int rob(int[] nums) {
    return rob2(nums, nums.length - 1);
  }
}