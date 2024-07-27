class Solution {
   
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer,String> hm = new HashMap<>();

        for(int i = 0 ; i < names.length ; i++)
        {
            hm.put(heights[i],names[i]);
        }

        Arrays.sort(heights);
        int low = 0;
        int high = heights.length-1;
        while(low<high)
        {
            int temp = heights[high];
            heights[high] = heights[low];
            heights[low] = temp;
            low++;
            high--;
        }
        String[]ans = new String[heights.length];
        for(int i = 0 ; i < heights.length ; i++)
        {
            ans[i] = hm.get(heights[i]);
        }
        return ans;
    }
}