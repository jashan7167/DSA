class Solution {
  public int search(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;

    return binary(low, high, nums, target);

  }

  public int binary(int low, int high, int[] nums, int target) {
    if (low > high) {
      return -1;
    }
    int mid = low + (high - low) / 2;
    if (target > nums[mid]) {

      return binary(mid + 1, high, nums, target);
    } else if (target < nums[mid]) {
      return binary(low, mid - 1, nums, target);
    } else {
      return mid;
    }

  }

  public static void main(String[] args) {
    int[] nums = { -1, 0, 3, 5, 9, 12 };
    Solution s = new Solution();
    System.out.println(s.search(nums, 9));

  }
}