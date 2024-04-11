//see optimal and better too
public class maxonsecutiveones {
  public static int findMaxConsecutiveOnes(int[] nums) {
    int max = Integer.MIN_VALUE;
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      count = 0;
      while (i < nums.length && nums[i] == 1) {
        count++;
        i++;
      }
      if (count > max) {
        max = count;
      }

    }
    return max;
  }

  public int findMaxConsecutiveOnes2(int[] nums) {
    int count = 0;
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        count++;
      } else {
        max = Math.max(max, count);
        count = 0;
      }
    }
    return Math.max(count, max);
  }

  public static void main(String[] args) {
    System.out.println(findMaxConsecutiveOnes(new int[] { 1, 1, 0, 1, 1, 1 }));
  }

}
