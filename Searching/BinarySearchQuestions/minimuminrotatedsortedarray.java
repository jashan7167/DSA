class Solution {
  public int findMin(int[] nums) {
    int low = 0, high = nums.length - 1;
    int min = Integer.MAX_VALUE;

    while (low <= high) {
      int mid = (low + high) / 2;

      // if left half is sorted go check in that if target can exist or not
      if (nums[low] <= nums[mid]) {
        // check if target can exist in sorted series or not
        min = Math.min(nums[low], min);
        low = mid + 1;

      }
      // if right half is sorted
      else {
        min = Math.min(nums[mid], min);
        high = mid - 1;

      }
    }

    return min;

  }
}