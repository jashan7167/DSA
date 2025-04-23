class Solution {
    public boolean isAnagram(String s, String t) {
        //check the edge cases first
        if(s.length() != t.length())
        {
            return false;
        }
        //we can have a frequency array which can have the time complexity O(n) and space complexity O(1) as we have to store 26 characters so it is constant not growing
        int [] charCounts = new int[26];

        for(int i = 0 ; i < s.length() ; i++)
        {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }

        for(int count : charCounts)
        {
            if(count!=0) return false;
        }        

        return true;
    }
}
