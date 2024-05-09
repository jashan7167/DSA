import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class checkifsorted {
  public static boolean check(int[] nums) {
      int first = nums[0];
      int count1=0;
    for (count1 = 1; count1 < nums.length; count1++)
    {
       if(nums[count1] != first)break;
       //when the loop has run to its end it means the elements are equal
       if(count1==nums.length-1)
       {
           return true;
       }
      }
    
      // If all elements are same, size of
        // HashSet should be 1. As HashSet contains only distinct values.
      
    int n = 0;
    while(n!=nums.length)
    {
      int []nums2 = nums.clone();
      int l = nums.length;
      while (n > nums.length) {
        n = n - l;
      }

      int[] temp = new int[n];
      // copying elements in temp numsay less than l-n
      for (int i = 0; i < n ; i++) {
        temp[i] = nums2[i];
      }

      // moving the rest element to index zero to D
      for (int i = n; i < l; i++) {
        nums2[i - n] = nums2[i];
      }

      // now copy elements from temp from d to size in original numsay
      for (int i = 0; i <  n; i++) {
        nums2[i + l-n] = temp[i];
      }
      int count = 0;
      for(int i = 0 ; i < nums.length-1 ; i++)
      {
          if(nums2[i]<=nums2[i+1])
          {
            count++;
          }
      }
      if(count==nums.length-1)
      {
          return true;
      }
      System.out.println(Arrays.toString(nums2));
      n++;
    }
    return false;
  }


  public static void main(String[] args) {
    System.out.println(check(new int[]{6,10,6}));
  }
}
