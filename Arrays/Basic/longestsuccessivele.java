import java.util.Arrays;

class longestsuccessive {
  public static  boolean linearsearch(int []arr,int num)
  {
    for(int i = 0 ; i < arr.length ; i++)
    {
      if(num==arr[i])
      {
        return true;
      }
    }
    return false;
  }
  public static int longestbrute(int[] nums) {
    int l = 1;
    for(int i = 0 ; i < nums.length ; i++)
    {
      int x = nums[i];
      int count = 1;
      while(linearsearch(nums,x+1)==true)
      {
        x = x+1;
        count++;
      }
      l = Math.max(count,l);
    }
    return l;
  }
  public static int longestconsecutivearray(int[]nums)
  {
    Arrays.sort(nums);
    int longest = 1;
    int lastSmaller = Integer.MIN_VALUE;
    int cnt = 0;
    for(int i = 0 ; i<nums.length ; i++)
    {
      if(nums[i]-1 == lastSmaller)
      {
        cnt ++;
        lastSmaller = nums[i];
      }
      if(nums[i]!=lastSmaller)
      {
        cnt = 1;
        lastSmaller = nums[i];
      }
      longest = Math.max(cnt,longest);
    }
    return longest;
  }




  public static void main(String[] args) {
    System.out.println(longestbrute(new int[] { 100, 4, 200, 1, 3, 2 }));
    System.out.println(longestconsecutivearray(new int[] { 100, 4, 200, 1, 3, 2 }));
  }
}