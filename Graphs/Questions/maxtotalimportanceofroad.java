import java.util.*;

class Solution {
  public long maximumImportance(int n, int[][] roads) {
    long ans = 0;
    int[] degree = new int[n];
    for (int i = 0; i < roads.length; i++) {
      for (int j = 0; j < roads[0].length; j++) {
        degree[roads[i][j]]++;
      }
    }
    Arrays.sort(degree);

    for (int i = 0; i < n; i++) {
      ans += (long) (n - i) * degree[n - i - 1];
    }

    return ans;
  }
}