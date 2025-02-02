class Solution {
  public int searchInsert(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;

    return binary(low, high, nums, target);
  }

  public int binary(int low, int high, int[] nums, int target) {

    if (low > high) {
      return low;
    }

    int mid = low + (high - low) / 2;

    if (nums[mid] == target) {
      return mid; // Target found at mid
    } else if (nums[mid] < target) {
      return binary(mid + 1, high, nums, target); // Search in the right half
    } else {
      return binary(low, mid - 1, nums, target); // Search in the left half
    }
  }
}
