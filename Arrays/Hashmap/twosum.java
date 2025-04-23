class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Brute force :- substract target from each and every nums[i] and then check the rest of array if it exists or not O(N^2) SPACE O(1)
        //Mid approach:- use binary search to find the complement but have to sort the array first O(nlogn) + O(logn) SPACE O(1)
        //optimal : - use hashmap to search the complement while traversing the array O(N) AND SPACE O(N)
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++)
        {
            int complement = target - nums[i];

            if(hm.containsKey(complement))
            {
                return new int[] {hm.get(complement),i};
            }

            hm.put(nums[i],i);
        }
        //return an empty array
        return new int[]{};
    }
}
