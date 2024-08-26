class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int h = nums[nums.length-1];
        //perform binary search on the 0 to max then find the pairs with diff less than mid value the value with the pairs equal to k or l==h will be answer
        //dont see kth and start using heap using your brain too
        while(l<h)
        {
           int  mid = (l+h)/2;
           int c = count(nums,mid);
            if(c>=k)
            {
                h = mid;
            }
            else
            {
                l = mid+1;
            }
        }
        return h;
    }
    //count the pairs with the difference less than equal to dist
    public static int count(int[]nums,int dist)
    {
        int l = 0;
        int res = 0;
        for(int r = 1 ; r<nums.length ; r++)
        {
            while(nums[r]-nums[l]>dist)
            {
                l++;
            }
            res+=r-l;
        }
        return res;
    }
}
