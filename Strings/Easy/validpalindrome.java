public class validpalindrome {
  
}
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        //this \s is a regex for the whitespaces
        s = s.replaceAll("\\s","");
        //expect the pattern a-zA-Z0-9 we will replace all with empty string
        s = s.replaceAll(
          "[^a-zA-Z0-9]", "");
        int low = 0;
        int high = s.length()-1;
        while(low<high)
        {
            if(s.charAt(low)!=s.charAt(high)) return false;
            else low++; high--;
        }

        return true;
        
    }
}