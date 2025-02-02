class Solution {
    public int getLucky(String s, int k) {
        // long sum;
        String first = "";
        for(char a : s.toCharArray())
        {
            int iform = (a-97)+1;
            first+=Integer.toString(iform);
        }
        while(k>0)
        {
            int temp = 0;
            for(char x : first.toString().toCharArray())
            {
                temp+= x - '0';
            }
            first = String.valueOf(temp);
            k--;
        }
        return Integer.parseInt(first.toString());
    
    }

    // public long sumofdigits(long a)
    // {
    //     long sum = 0;
    //     while(a!=0)
    //     {
    //         sum+=a%10;
    //         a = a/10;
    //     }
    //     return sum;
    // }
}
