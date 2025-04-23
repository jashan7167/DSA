class Solution {
    public boolean containsDuplicate(int[] nums) {

        //brute force
        // for(int i = 0 ; i < nums.length ; i++)
        // {
            
        //     for(int j = i+1 ; j < nums.length ; j++)
        //     {
        //         if(nums[i]==nums[j])
        //         {
        //             return true;
        //         }
        //     }
        // }
        // return false;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0 ; i < nums.length ; i++)
        {
            if(set.contains(nums[i])) return true;

            set.add(nums[i]);
        }
        
        return false; 
        
    }
}
