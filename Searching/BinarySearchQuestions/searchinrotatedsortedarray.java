class Solution {
    public int search(int[] nums, int target) {
        int low = 0,high = nums.length-1;

        while(low<=high)
        {
            int mid = (low+high)/2;

            if(nums[mid]==target)
            {
                return mid;
            }
            //if left half is sorted go check in that if target can exist or not
            if(nums[low]<=nums[mid])
            {
                //check if target can exist in sorted series or not
                if(nums[low]<=target && nums[mid]>target)
                {
                    high = mid-1;
                }
                else
                {
                    low = mid+1;
                }
            }
            //if right half is sorted
            else
            {
                if(nums[mid]<target && nums[high]>=target)
                {
                    low = mid+1;
                }
                else
                {
                    high = mid-1;
                }
            }
        }

        return -1;


        
    }
}




