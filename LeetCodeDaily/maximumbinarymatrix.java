class Solution {

    private void fliprow(int[][]grid , int row)
    {
        for(int col = 0  ; col < grid[0].length;col++)
        {
            grid[row][col] = 1 - grid[row][col];
        }
    }

    private void flipcol(int[][]grid , int col)
    {
        for(int row = 0 ; row < grid.length ; row ++)
        {
            grid[row][col] = 1 -  grid[row][col];
        }
    }
    private int checkrow(int [] nums)
    {
        int result = 0;
        for(int num : nums)
        {
            result = result*2 + num;
        }
        return result;
    }

    public int matrixScore(int[][] grid) {
        int nRows = grid.length , nCols = grid[0].length;

        for(int row = 0 ; row < nRows ;row++)
        {
            if(grid[row][0]==0)
            {
                fliprow(grid,row);
            }
        }

        for(int col = 1 ; col < nCols ; col++ )
        {
            int countone = 0;
            for(int row = 0 ; row < nRows ; row++)
            {
                if(grid[row][col]==1)
                {
                    countone++;
                }
            }
            if(countone*2 < nRows)
            {
                flipcol(grid,col);
            }
        }

        int totalScore = 0;
        for(int[]row : grid)
        {
            totalScore +=checkrow(row);
        }

        return totalScore;

    }
    
}
