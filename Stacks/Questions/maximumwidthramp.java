class Solution {
    public int maxWidthRamp(int[] nums) {
        // doesnot work as they talked about the pair contigous so cannot solve in this
        // sorted manner
        // Arrays.sort(nums);
        // return nums[nums.length-1]-nums[0];

        //brute force solution
        int max = Integer.MIN_VALUE;
        // for (int i = 0; i <= nums.length - 2; i++) {
            
        //     for (int j = i; j < nums.length; j++) {
        //        if(nums[j]>=nums[i])
        //        {
        //         max = Math.max(max,j-i);
        //        }
        //     }
        // }
        // return max;
        Stack<Integer> st = new Stack<>();
       int n = nums.length;
        for(int i = 0 ; i < n ; i++)
        {
            if(st.isEmpty() || nums[st.peek()]>nums[i])
            {
                st.push(i);
            }
        }
        for(int j = n-1 ; j>=0 ; j--)
        {
            while(!st.isEmpty() && nums[st.peek()]<=nums[j])
            {
                max = Math.max(max,j-st.pop());
            }
        }
        return max;
    }
}
