//see optimal too

public class singleno {

  public static int singleNumber(int[] nums) {
      for(int i = 0 ; i < nums.length ; i++)
      {
        int count = 0;
        for(int j = 0 ; j < nums.length ; j++)
        {
          if(nums[i]==nums[j])
          {
            count++;
          }
       
        }
        if (count == 1) {
          return nums[i];
        }
      }

      return -1;
    }
  public static void main(String[] args) {
    System.out.println(singleNumber(new int[]{2,2,1}));

  }
}
