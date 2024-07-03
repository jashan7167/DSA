class Solution {
    public int minDifference(int[] nums) {
        if(nums.length<=4)
        {
            return 0;
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int l = 0 ; l <4 ; l++)
        {
            //we are leaving three from end at start and then expand the window further right and make the window smaller from left i.e shifting the window to right always having three elements outside
            int r = nums.length-4 + l;
            min = Math.min(min,nums[r]-nums[l]);
        }
        return min;
    }
}