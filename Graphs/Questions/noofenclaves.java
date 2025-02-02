class Solution {
  public int numEnclaves(int[][] grid) {
    // first mark all the X's as visited and 0's as unvisited
    int n = grid.length;
    int m = grid[0].length;
    int[][] vis = new int[n][m];

    for (int j = 0; j < m; j++) {
      // first row
      if (vis[0][j] == 0 && grid[0][j] == 1) {
        dfs(vis, grid, 0, j);
      }
      // last row
      if (vis[n - 1][j] == 0 && grid[n - 1][j] == 1) {
        dfs(vis, grid, n - 1, j);
      }
    }

    for (int j = 0; j < n; j++) {
      // first col
      if (vis[j][0] == 0 && grid[j][0] == 1) {
        dfs(vis, grid, j, 0);
      }
      // last row
      if (vis[j][m - 1] == 0 && grid[j][m - 1] == 1) {
        dfs(vis, grid, j, m - 1);
      }
    }
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (vis[i][j] == 0 && grid[i][j] == 1) {
          count++;
        }
      }
    }

    return count;

  }

  public void dfs(int[][] vis, int[][] board, int row, int col) {
    int n = board.length;
    int m = board[0].length;
    vis[row][col] = 1;
    int[] delRow = { 0, +1, 0, -1 };
    int[] delCol = { 1, 0, -1, 0 };
    for (int i = 0; i < 4; i++) {
      int nrow = row + delRow[i];
      int ncol = col + delCol[i];

      if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && board[nrow][ncol] == 1) {
        dfs(vis, board, nrow, ncol);
      }
    }
  }
}