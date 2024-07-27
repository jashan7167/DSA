class Solution {
  public static int minCost(int arr[], int N, int K) {
    if (N == 0) {
      return 0;
    }
    int min = Integer.MAX_VALUE;
    for (int j = 1; j <= K; j++) {
      if (N - j >= 0) {
        int cost = minCost(arr, N - j, K) + Math.abs(arr[N] - arr[N - j]);
        min = Math.min(min, cost);
      }
    }

    return min;
  }

  public int minimizeCost(int arr[], int N, int K) {
    return minCost(arr, N - 1, K);
  }
}