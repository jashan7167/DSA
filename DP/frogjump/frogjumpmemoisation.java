class Solution {
  public static int minCost(int arr[], int N, int K, int[] dp) {
    if (N == 0) {
      return 0;
    }
    if (dp[N] != -1) {
      return dp[N];
    }
    int min = Integer.MAX_VALUE;
    for (int j = 1; j <= K; j++) {
      if (N - j >= 0) {
        int cost = minCost(arr, N - j, K, dp) + Math.abs(arr[N] - arr[N - j]);
        min = Math.min(min, cost);
        dp[N] = min;
      }
    }

    return min;
  }

  public int minimizeCost(int arr[], int N, int K) {
    int[] dp = new int[N];
    Arrays.fill(dp, -1);
    return minCost(arr, N - 1, K, dp);
  }
}