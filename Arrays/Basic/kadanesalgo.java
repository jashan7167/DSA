//first algorithm you will always tell that i will iterate at all the subarrays which is the n^3 algorithm
//optimise this solution with n^2 we dont need the third loop at keep on adding
//kadanes's algorithm is the best solution for this problem with n complexity and 1 space complexity 
public class kadanesalgo {
  public static int maxSubArray(int[] nums) {

    int sum = 0;
    int max = nums[0];
    for (int i : nums) {
      sum += nums[i];
      if (sum > max)
        max = sum;
      if (sum < 0)
        sum = 0;
    }
    return max;
  }

  public static void main(String[] args) {

  }
}
