class Solution {
  public int[][] largestLocal(int[][] grid) {
    int nrows = grid.length;
    int ncols = grid[0].length;
    int[][] res = new int[nrows - 2][ncols - 2];

    for (int i = 0; i < nrows - 2; i++) {
      for (int j = 0; j < ncols - 2; j++) {
        res[i][j] = findLarge(grid, i, j);
      }
    }

    return res;
  }

  public static int findLarge(int[][] grid, int r, int c) {
    int best = Integer.MIN_VALUE;
    for (int i = r; i < r + 3; i++) {
      for (int j = c; j < c + 3; j++) {
        best = Math.max(best, grid[i][j]);
      }
    }
    return best;
  }
}