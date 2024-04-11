import java.util.Arrays;

public class rearrangearray {
  public static int[] rearrangeArray(int[] nums) {
    int l = nums.length / 2;
    int[] pos = new int[l];
    int[] neg = new int[l];
    for (int i = 0, k = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        pos[k] = nums[i];
        k++;
      }
    }
    for (int i = 0, k = 0; i < nums.length; i++) {
      if (nums[i] < 0) {
        neg[k] = nums[i];
        k++;
      }
    }
    int k = 0;
    for (int i = 0; i < nums.length; i = i + 2) {
      nums[i] = pos[k];
      nums[i + 1] = neg[k];
      k++;
    }
    return nums;
  }

  public static int[] rearrangeArray2(int[] nums) {
    int pos = 0;
    int neg = 1;
    int[] ans = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= 0) {
        ans[pos] = nums[i];
        pos += 2;
      } else {
        ans[neg] = nums[i];
        neg += 2;
      }
    }
    return ans;

  }



  public static void main(String[] args) {
    System.out.println(Arrays.toString(rearrangeArray2(new int[] { -1, 1 })));

  }
}
