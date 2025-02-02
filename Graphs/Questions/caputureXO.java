class Solution {
  public void dfs(int[][] vis, char[][] board, int row, int col) {
    int n = board.length;
    int m = board[0].length;
    vis[row][col] = 1;
    int[] delRow = { 0, +1, 0, -1 };
    int[] delCol = { 1, 0, -1, 0 };
    for (int i = 0; i < 4; i++) {
      int nrow = row + delRow[i];
      int ncol = col + delCol[i];

      if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && board[nrow][ncol] == 'O') {
        dfs(vis, board, nrow, ncol);
      }
    }
  }

  public void solve(char[][] board) {
    // first mark all the X's as visited and 0's as unvisited
    int n = board.length;
    int m = board[0].length;
    int[][] vis = new int[n][m];

    for (int j = 0; j < m; j++) {
      // first row
      if (vis[0][j] == 0 && board[0][j] == 'O') {
        dfs(vis, board, 0, j);
      }
      // last row
      if (vis[n - 1][j] == 0 && board[n - 1][j] == 'O') {
        dfs(vis, board, n - 1, j);
      }
    }

    for (int j = 0; j < n; j++) {
      // first col
      if (vis[j][0] == 0 && board[j][0] == 'O') {
        dfs(vis, board, j, 0);
      }
      // last row
      if (vis[j][m - 1] == 0 && board[j][m - 1] == 'O') {
        dfs(vis, board, j, m - 1);
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (vis[i][j] == 0 && board[i][j] == 'O') {
          board[i][j] = 'X';
        }
      }
    }
  }
}