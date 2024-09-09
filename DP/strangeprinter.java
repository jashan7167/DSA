class Solution {
    public int strangePrinter(String s) {
        int n  = s.length();
        int[][]dp = new int[n+1][n+1];
        for(int[]arr : dp)
        {
            Arrays.fill(arr,-1);
        }
        return solve(0,n-1,s,dp);
    }
//two approaches are working here:
//1. basic one which says upto where the characters are equal add one for that and recursively solve for the others and print
//2 . optimal appraoch print the characters first which are similar from the start and after the different character the middle one can be replaced after printing the repeated characters hence the solve(i,j-1) and solve(j,r,s)
    public int solve(int l , int r , String s,int[][]dp)
    {
        if(l==r) return 1;
        if(l>r) return 0;
        if(dp[l][r]!=-1) return dp[l][r];
        int i = l+1;
        while(i<=r && s.charAt(i)==s.charAt(l))
        {
            i++;
        }
        if(i==r+1) return 1;
        int basic = 1+ solve(i,r,s,dp);
        int lalach = Integer.MAX_VALUE;
        for(int j = i ; j<=r ; j++)
        {
            if(s.charAt(j)==s.charAt(l))
            {
                int ans = solve(i,j-1,s,dp) + solve(j,r,s,dp);
                lalach = Math.min(lalach,ans);
            }
        }
        return dp[l][r] = Math.min(basic,lalach);
    }
}
