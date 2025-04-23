class Solution {
    public int maxAbsoluteSum(int[] nums) {
        //constraints big brute force wont work
        //maybe kadane's algorithm?? 
        //once for the max maximum values and once for the min minimum values
    //think of this invertly like what would be the max or min until this point of the array then it becomes a prefix sum question
        int cur_sum = 0;
        int min_sum = 0;
        int max_sum = 0;
        int res = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            cur_sum+=nums[i];

            res = Math.max(res,Math.max(Math.abs(cur_sum-min_sum),Math.abs(cur_sum-max_sum)));
            min_sum = Math.min(min_sum,cur_sum);
            max_sum = Math.max(max_sum,cur_sum);
        }

        return res;
        
    }
}
