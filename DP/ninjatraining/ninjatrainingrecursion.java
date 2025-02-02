//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.maximumPoints(arr, N);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][], int N) {
        return f(N-1,3,arr);
    }
    
    public int f(int ind,int last,int[][]arr)
    {
        if(ind==0)
        {
            int maxi = 0;
            
            for(int i = 0 ; i < 3 ;i++)
            {
                if(last!=i)
                {
                    maxi = Math.max(arr[ind][i],maxi);
                }
            }
            
            return maxi;
        }
        
        int maxi = 0;
            
        for(int i = 0 ; i < 3 ; i++)
        {
            if(i!=last)
            {
                int points = arr[ind][i] + f(ind-1,i,arr);
               maxi =  Math.max(maxi,points);
            }
            
        }
        
        return maxi;
    }
    
}