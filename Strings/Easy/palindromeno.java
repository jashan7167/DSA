class Solution {
    public boolean isPalindrome(int x) {
        String a = Integer.toString(x);
        String rev="";
        char ch;
        for(int i = 0 ; i < a.length() ; i++)
        {
            ch = a.charAt(i);
            rev = ch + rev;
        }

        if(rev.equals(a))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}