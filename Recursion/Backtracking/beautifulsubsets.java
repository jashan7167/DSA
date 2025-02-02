class Solution {
        private int count;
        private Map<Integer,Integer> visited;


        public Solution()
        {
            this.count = 0;
            this.visited = new HashMap<>();
        }


    public int beautifulSubsets(int[] nums, int k) {
        explore(nums,k,0);
        return count-1;
    }
    public void explore(int[]nums,int k , int index)
    {
        //base case this will each with paths that satisify the coundition hence we can increase the count
        if(index == nums.length)
        {
            count++;
            return;
        }

        int num = nums[index];

        if(!visited.containsKey(num-k) && !visited.containsKey(num+k))
        {
            //include num[i]
            visited.put(num,visited.getOrDefault(num,0)+1);
            explore(nums,k,index+1);
            //backtrack to call without including the num[i]
            visited.put(num,visited.get(num)-1);
            if(visited.get(num)==0)
            {
                visited.remove(num);
            }
        }

        explore(nums,k,index+1);
    }
}
