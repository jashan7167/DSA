class Solution {
  public int numberOfSubarrays(int[] nums, int k) {
    int left = 0, m = 0, right = 0;
    int odd = 0;
    int ans = 0;
    while (right < nums.length) {
      if (nums[right] % 2 != 0) {
        odd++;
      }

      while (odd > k) {
        if (nums[left] % 2 != 0) {
          odd--;
        }
        left = left + 1;
        m = left;
      }

      if (odd == k) {
        while (nums[m] % 2 == 0) {
          m++;
        }
        ans += (m - left) + 1;
      }

      right++;
    }

    return ans;

  }
}