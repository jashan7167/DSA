import java.util.LinkedList;
import java.util.Queue;

class Solution {
  class Tuple {
    int first;
    int second;
    int third;

    Tuple(int first, int second, int third) {
      this.first = first;
      this.second = second;
      this.third = third;
    }
  }

  public int shortestPathBinaryMatrix(int[][] grid) {
    int n = grid.length;

    // check if the ending or starting point is blocked
    if (grid[0][0] == 0 && n == 1) {
      return 1;
    }
    if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
      return -1;
    }

    int[][] dist = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        dist[i][j] = (int) 1e9;
      }
    }

    Queue<Tuple> q = new LinkedList<>();
    dist[0][0] = 1;
    q.add(new Tuple(1, 0, 0));
    int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
    int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

    while (!q.isEmpty()) {
      Tuple it = q.poll();
      int dis = it.first;
      int r = it.second;
      int c = it.third;

      for (int i = 0; i < 8; i++) {
        int newr = r + dr[i];
        int newc = c + dc[i];

        if (newr >= 0 && newr < n && newc >= 0 && newc < n && grid[newr][newc] == 0 &&
            dis + 1 < dist[newr][newc]) {
          dist[newr][newc] = 1 + dis;
          if (newr == n - 1 && newc == n - 1) {
            return dist[newr][newc];
          }
          q.add(new Tuple(dist[newr][newc], newr, newc));
        }
      }
    }

    return -1;
  }
}
