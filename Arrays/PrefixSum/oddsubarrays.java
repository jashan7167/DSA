class Solution {
    public int numOfSubarrays(int[] arr) {
        //constraints too big for a brute force solution need a optimal solution
        //maybe dp,prefix sum??
        //try prefix sum
        // keep track of the odd and even prefix sum for the odd add 1 + even_count as when the current_sum is odd removing the even prefix sum would make it odd hence that amount of subarrays would also be created itself + amount of even subarrays deleted
        //now for even add the odd prefixes
        // int count = 0;
        // for(int i = 0 ; i < arr.length ; i++)
        // {
        //     int sum = arr[i];
        //     for(int j = i+1 ; j < arr.length ; i++)
        //     {
        //         sum = sum + arr[j];
        //         if(sum%2!=0)
        //         {
        //             count++;
        //         }
        //     }
        // }
        int curr_sum = 0;
        int odd_count = 0;
        int even_count = 0;
        int subarrays = 0;
        int mod = 1000000007;
        for(int element : arr)
        {
            curr_sum+=element;
            if(curr_sum%2==0) //even
            {
                subarrays = (subarrays + odd_count)%mod;
                even_count+=1;
            }
            else //odd
            {
                subarrays = (subarrays+ 1 + even_count)%mod;
                odd_count+=1;
            }
        }

        return subarrays;
    }
}
