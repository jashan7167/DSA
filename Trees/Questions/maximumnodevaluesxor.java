import java.util.Arrays;

class Solution {
  public long maximumValueSum(int[] nums, int k, int[][] edges) {
    long total = 0;
    for (int num : nums) {
      total += num;
    }

    // Creating a delta array
    int[] delta = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      delta[i] = (nums[i] ^ k) - nums[i];
    }

    // Sorting the delta values to pair the highest ones (greedy solution)
    Arrays.sort(delta);

    // Process the delta array from the highest values
    for (int j = delta.length - 1; j > 0; j -= 2) {

      int path_res = delta[j] + delta[j - 1];

      if (path_res >= 0) {
        total += path_res;
      }
    }

    return total;
  }
}
