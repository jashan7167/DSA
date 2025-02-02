class Solution {
    // public int rob2(int[]nums,int ind,int[]dp)
    // {
    //     if(ind==0) return nums[0];
    //     if(ind<0)return 0;
    //     if(dp[ind]!=-1) return dp[ind];

    //     int max = Integer.MIN_VALUE;
    //     int pick = nums[ind] + rob2(nums,ind-2,dp);
    //     int notpick = 0 + rob2(nums,ind-1,dp);
    //     dp[ind] =  Math.max(pick,notpick);
    //     return Math.max(pick,notpick);
    // }
    public int rob(int[] nums) {
      int prev = nums[0];
      int prev2 = 0;

      for(int i = 1 ; i < nums.length ; i++)
      {
        int take = nums[i];
        if(i>1)
        {
            take+=prev2;
        }
        int nontake = 0 + prev;
        int curri = Math.max(take,nontake);
        prev2 = prev;
        prev = curri;
      }

      return prev;
    }
}