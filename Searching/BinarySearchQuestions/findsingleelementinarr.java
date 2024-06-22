class Solution {
  public int singleNonDuplicate(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    if (nums[0] != nums[1]) {
      return nums[0];
    }
    if (nums[nums.length - 1] != nums[nums.length - 2]) {
      return nums[nums.length - 1];
    }

    int l = 1, h = nums.length - 2;

    while (l <= h) {
      int m = (l + h) / 2;

      if (nums[m] != nums[m - 1] && nums[m] != nums[m + 1]) {
        return nums[m];
      }
      // we are at odd and previous is even we at even next is odd
      if ((m % 2 == 1 && nums[m] == nums[m - 1]) || (m % 2 == 0 && nums[m] == nums[m + 1])) {
        l = m + 1;
      }
      // else we need to eliminate the right array
      else {
        h = m - 1;
      }
    }

    return -1;

  }
}