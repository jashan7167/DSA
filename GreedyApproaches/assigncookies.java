class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length==0)
        {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int assigned = 0;
        int j =0;
        int i = 0;
        while(j<s.length && i<g.length)
        {
            if(g[i]>s[j])
            {
                j++;
            }
            else if(g[i]<=s[j])
            {
                assigned++;
                j++;
                i++;
            }
        }

        return assigned;


        
    }
}
