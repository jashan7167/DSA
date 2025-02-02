class Solution {
    public int longestSubarray(int[] nums) {
        //bitwise and of two no is always less than the maximum of two numbers
        //hence normally we can think of finding the maximum by sorting the array and then finding the length
        //galti kri sort krke sub array dekhna with the maximum elements baaki shi tha
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++)
        {
            max = Math.max(nums[i],max);
        }
        int cnt = 0;
        int len = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(nums[i]==max)
            {
                cnt++;
            }
            else
            {
                cnt = 0;
            }
            len = Math.max(cnt,len);
        }

        return len;

        
    }
}
