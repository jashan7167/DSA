class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {

        int[][]res = new int[rowSum.length][colSum.length];

        for(int i = 0 ; i < rowSum.length ; i++)
        {
            res[i][0] = rowSum[i];
        }

        for(int j = 0 ; j < colSum.length ; j++)
        {
            long currcolSum = 0;
            for(int i = 0 ; i < rowSum.length ; i++)
            {
                currcolSum+=res[i][j];
            }
            int r = 0;
            while(currcolSum>colSum[j])
            {
                long diff = currcolSum - colSum[j];
                long shift = Math.min(diff,res[r][j]);
                res[r][j]-=shift;
                res[r][j+1]+=shift;
                currcolSum-=shift;
                r++;
            }
        }

        return res;
        
    }
}