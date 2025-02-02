class Solution {
    public int minSubarray(int[] nums, int p) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        long totalSum = 0;
        for(int num : nums)
        {
            totalSum+=num;
        }
        int rem = (int)(totalSum%p);

        if(rem==0) return 0;

        hm.put(0,-1);
        long prefixSum = 0;
        int minLength = nums.length;
        for(int i = 0 ; i < nums.length ; i++)
        {
            prefixSum+=nums[i];
            int currentMod = (int)(prefixSum%p);
            int targetMod = (currentMod - rem + p)%p;

            if(hm.containsKey(targetMod))
            {
                minLength = Math.min(minLength,i-hm.get(targetMod));
            }

            hm.put(currentMod,i);
        }
    //if we can remove then return -1 else return minimum length
        return minLength == nums.length ? -1 : minLength;
        
        
    }
}
