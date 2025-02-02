class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeroes =0;
        int max = 0;
        for(int i = 0 , j = 0 ; j < nums.length ; j++)
        {
            if(nums[j]==0)
            {
                zeroes++;
            }

            while(zeroes>k && i<=j)
            {
                if(nums[i++]==0)
                {
                    zeroes--;
                }
            }
            max = Math.max(max,j-i+1);
        }

        return max;
    }
}