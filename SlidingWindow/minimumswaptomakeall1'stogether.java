class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        //window size is basically equal to the total no of one's in the input
        int windowsize = 0;
        for(int el : nums)
        {
            if(el==1)
            {
                windowsize++;
            }
        }
        int l = 0;
        int window_ones= 0 ,maxwindow_ones = 0;
        for(int r = 0 ; r < 2*n ; r++)
        {
            if(nums[r%n]==1)
            {
                window_ones++;
            }
            while((r-l+1)>windowsize)
            {
                window_ones-=nums[l%n];
                l+=1;
            }
            maxwindow_ones = Math.max(window_ones,maxwindow_ones);
        }

        return windowsize - maxwindow_ones;

    }
}