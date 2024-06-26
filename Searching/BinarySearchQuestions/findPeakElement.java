class Solution {
    public int findPeakElement(int[] nums) {
        //single element
        if(nums.length==1)
        {
            return 0;
        }
        if(nums[0]>nums[1])
        {
            return 0;
        }
        if(nums[nums.length-1]>nums[nums.length-2])
        {
            return nums.length-1;
        }
        int start = 1;
        int end = nums.length-2;

        while(start<=end)
        {
            int mid = (start+end)/2;

            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
            {
                return mid;
            }
            else if(nums[mid]<nums[mid-1])
            {
                end = mid-1;
            }
            else if(nums[mid]<nums[mid+1])
            {
                start = mid+1;
            }
        }
        //surely we will find peak but we need to return a dummy return statement
        return -1;


    }
}