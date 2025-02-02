public class majorityel {
  public int majorityElement(int[] nums) {
    int threshhold = nums.length / 2;

    for (int i = 0; i < nums.length; i++) {
      int count = 0;
      for (int j = i; j < nums.length; j++) {
        if (nums[i] == nums[j]) {
          count++;
        }
      }
      if (count > threshhold) {
        return nums[i];
      }
    }
    return -1;
  }

  public int majorityElement2(int[] nums) {
    return moorevotingalgorithm(nums, nums[0], 0);
  }

  public int moorevotingalgorithm(int[] nums, int val, int index) {
    int count = 0;
    for (int i = index; i < nums.length; i++) {
      if (val == nums[i]) {
        count++;
      } else {
        count--;
      }
      if (count < 0) {
        return moorevotingalgorithm(nums, nums[i], i);
      }
    }
    return val;
  }

  public static void main(String[] args) {

  }
}
