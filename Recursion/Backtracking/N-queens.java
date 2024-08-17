class Solution {
    List<List<String>> list = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        boolean board[][] = new boolean[n][n];
        queenplace(board, 0, n);
        return list;
    }

    public void queenplace(boolean board[][],int row,int queens)
    {
        if(queens==0)
        {
            addInList(board);
            return;
        }

        if(row==board.length) return;

        for(int col = 0 ; col < board.length ; col++)
        {
            if(isSafe(board,row,col)==true)
            {
                //make that position true and move to the next row 
                board[row][col] = true;
                //make the no of queens less in the next row previously we placed one
                queenplace(board,row+1,queens-1);
                //while backtracking and finishing one instance of recursion we go to the
                //column making the position on the board false
                board[row][col] = false;
            }
        }
    }
        public boolean isSafe(boolean board[][],int row,int col)
        {
            int r = row,c = col;
            while(r>=0)
            {
                if(board[r][c]==true) return false;
                r--;
            }
            r = row;
            //previous diagnol
            while(r>=0 && c>=0)
            {
                if(board[r][c]==true) return false;
                r--;
                c--;
            }
            //positive diagnol
            r = row;c=col;
            while(r>=0 && c<board.length)
            {
                if(board[r][c]==true) return false;
                r--;
                c++;
            }

            return true;
        }

        public void addInList(boolean board[][])
        {
            List<String> ls = new ArrayList<>();
            for(int i = 0 ; i < board.length ; i++)
            {
                String s="";
                for(int j= 0 ; j < board.length ; j++)
                {
                    if(board[i][j]==false)
                    {
                        s+='.';
                    }
                    else s+='Q';
                }
                ls.add(s);
            }
            list.add(ls);
        }
    }

