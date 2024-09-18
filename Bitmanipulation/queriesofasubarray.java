class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[]ans = new int[queries.length];
        int[]prefix = new int[arr.length];
        int k = 0;
        // for(int i = 0 ; i < queries.length ; i++)
        // {
        //     int left = queries[i][0];
        //     int right = queries[i][1];
        //     int xor = 0;
        //     for(int j = left ; j<=right ; j++)
        //     {
        //         xor^=arr[j];
        //     }
        //     ans[k] = xor;
        //     k++;
        // }
        //using the trick where x ^ y ^ x = y then we can calculate the prefix sum to find the answer
        prefix[0] = arr[0];
        for(int i = 1 ; i < arr.length ; i++)
        {
            prefix[i] = prefix[i-1] ^ arr[i]; 
        }

           for(int i = 0 ; i < queries.length ; i++)
        {
            int left = queries[i][0];
            int right = queries[i][1];
            int xor = 0;
            if(left==0)
            {
                ans[k] = prefix[right];
            }
            else
            {
                ans[k] = prefix[right] ^ prefix[left-1];
            }
            k++;
        }
        return ans;
    }
}
