class Solution {
    public int regionsBySlashes(String[] grid) {
        int rows1 = grid.length,cols1 = grid[0].length();
        int[][]grid2 = new int[rows1*3][cols1*3];


        for(int i = 0 ; i < rows1 ; i++)
        {
            for(int j = 0 ; j < cols1 ; j++)
            {
            int rows2 = i*3;
            int cols2 = j*3;
            if(grid[i].charAt(j)=='/')
            {
                grid2[rows2][cols2+2] = 1;
                grid2[rows2+1][cols2+1] = 1;
                grid2[rows2+2][cols2] = 1;
            }
            else if(grid[i].charAt(j)=='\\')
            {
                grid2[rows2][cols2] = 1;
                grid2[rows2+1][cols2+1] = 1;
                grid2[rows2+2][cols2+2] = 1;
            }
                
            }
        }
        int[][]vis = new int[grid2.length][grid2[0].length];
        int count = 0;
        for(int i = 0 ; i < grid2.length ; i++)
        {
            for(int j = 0 ; j < grid2[0].length; j++)
            {
                if(grid2[i][j]==0 && vis[i][j]==0)
                {
                    dfs(vis,grid2,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int[][]vis,int[][]grid,int r,int c)
    {
        if(r<0 || c<0 || r==grid.length || c==grid[0].length || grid[r][c]!=0 || vis[r][c]==1)
        {
            return;
        }
        vis[r][c] = 1;
        int[][]directions = {{r+1,c},{r,c+1},{r-1,c},{r,c-1}};

        for(int i = 0 ; i < 4 ; i++)
        {
            dfs(vis,grid,directions[i][0],directions[i][1]);
        }
    }
    
}
