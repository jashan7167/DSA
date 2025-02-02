class Solution {
    public int[] arrayRankTransform(int[] arr) {
        //clone method can be used to copy Array 
        int[]temp = arr.clone();
        HashMap<Integer,Integer> hm = new HashMap<>();
        Arrays.sort(temp);
        int rank = 1;
        for(int i = 0 ; i < temp.length ; i++)
        {
            if(!hm.containsKey(temp[i]))
            {
                hm.put(temp[i],rank);
                rank++;
            }
        }
        for(int i = 0 ; i < arr.length ; i++)
        {
            arr[i] = hm.get(arr[i]);
        }

        return arr;

    }
}
