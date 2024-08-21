class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                res += magic(i, j, grid);
            }
        }
        return res;
    }

    public int magic(int r, int c, int[][] grid) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (hs.contains(grid[i][j]) || grid[i][j] <1 || grid[i][j] > 9) {
                    return 0;
                }
                hs.add(grid[i][j]);
            }
        }
        int conditionsum = grid[r][c] + grid[r][c+1] + grid[r][c+2];
        // check for rows now
        for (int i = r; i < r + 3; i++) {
            int sum = 0;
            for (int j = c; j < c + 3; j++) {
                sum += grid[i][j];
            }
            if (sum != conditionsum) {
                return 0;
            }
        }
        // check for columns now
        for (int j = c; j < c + 3; j++) {
            if ((grid[r][j] + grid[r + 1][j] + grid[r + 2][j]) != conditionsum) {
                return 0;
            }
        }

        // check for diagnols
        if ((grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2]) != conditionsum
                || (grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c]) != conditionsum){
            return 0;
        }
        return 1;
}}
