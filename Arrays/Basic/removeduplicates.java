import java.util.Arrays;

class removeduplicates {
  public static int[] removeDuplicates(int[] nums) {
    int k = 0;
    for (int i = 0; i < nums.length; i++) {
      int temp = nums[i];
      while (i + 1 < nums.length && temp == nums[i + 1]) {
        i++;
      }
      nums[k] = nums[i];
      k++;
    }
    System.out.println(k);
    return nums;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 })));

  }

}