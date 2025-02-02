import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class nextpermutation {
  public void nextPermutation(int[] nums) {
    int n = nums.length;
    int ind = -1;

    for(int i = n-2 ; i>=0; i++)
    {
      if(nums[i]<nums[i+1])
      {
        ind = i;
        break;
      }
    }
    if(ind == -1)
    {
      Collections.reverse(Arrays.asList(nums));
    }
    for(int i = n-1 ; i>ind ; i--)
    {
      if(nums[i]>nums[ind])
      {
        int temp = nums[i];
        nums[i] = nums[ind];
        nums[ind] = temp;
        break;
      }
    }
     Collections.reverse(Arrays.asList(nums).subList(ind + 1, n));

  }
  public static void main(String[] args) {
    
  }
}
