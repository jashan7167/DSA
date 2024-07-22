//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
  public static void main(String args[]) throws IOException {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();

      }
      Solution obj = new Solution();
      int res = obj.minimumEnergy(arr, N);
      System.out.println(res);

    }
  }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
  public int frogjump(int n, int[] dp, int[] height) {
    if (n == 0) {
      return 0;
    }
    if (dp[n] != -1) {
      return dp[n];
    }
    int left = frogjump(n - 1, dp, height) + Math.abs(height[n] - height[n - 1]);
    int right = Integer.MAX_VALUE;
    if (n > 1) {
      right = frogjump(n - 2, dp, height) + Math.abs(height[n] - height[n - 2]);
    }
    return dp[n] = Math.min(left, right);
  }

  public int minimumEnergy(int arr[], int N) {
    int[] dp = new int[N + 1];
    Arrays.fill(dp, -1);
    return frogjump(N - 1, dp, arr);
  }
}