class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] arr = new int[m][n];
        // int a = 0;

        if(original.length > n*m || original.length < n*m)
        {
            return new int[][]{};
        }

        // for(int i = 0 ; i < m ; i++)
        // {
        //     for(int j = 0 ; j < n ; j++)
        //     {
        //         arr[i][j] = original[a];
        //         a++;
        //     }
        // }

        //try to do it in n complexity or optimise the code
        int r = 0;
        int c = 0;
        int count = 1;
        for(int i = 0 ; i < n*m ; i++)
        {
            if(r>m-1 || c > n-1) break;
            arr[r][c] = original[i];
            if(count%n==0)
            {
                System.out.println(count);
                r++;
                c=0;
            }
            else
            {
            c++;
            }
            count++;
        }
        

        return arr;
        
    }
}
