class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
        {
            return false;
        }
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];

        for(int i = 0 ; i < s1.length() ; i++)
        {
            hash1[s1.charAt(i)-'a']++;
            hash2[s2.charAt(i)-'a']++;
        }

        for(int i = 0 ; i < s2.length() - s1.length() ; i++)
        {
            if(match(hash1,hash2)) return true;
            hash2[s2.charAt(i)-'a']--;
            hash2[s2.charAt(i+s1.length())-'a']++;
        }

        return match(hash1,hash2);
    }
    private boolean match(int[]s1Count , int[]s2Count)
    {
        for(int i = 0 ; i < 26 ; i++)
        {
            if(s1Count[i]!=s2Count[i])
            {
                return false;
            }
        }
        return true;
    }
}
