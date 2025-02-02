class Solution {
    public List<String> commonChars(String[] words) {
        List<String> ls = new ArrayList<>();
        int[]last = count(words[0]);

        for(int i = 1 ; i < words.length ; i++)
        {
            last = takemin(last,count(words[i]));
        }

        for(int i = 0 ; i < 26 ; i++)
        {
            if(last[i]!=0)
            {
                char ch = (char)('a'+i);
                String s = String.valueOf(ch);
                while(last[i]>0)
                {
                    ls.add(s);
                    last[i]--;
                }
            }
        }

        return ls;
    }
    public int[] takemin(int[]a,int[]b)
    {
        int[]t = new int[26];
        for(int i = 0 ; i < 26 ; i++)
        {
            t[i] = Math.min(a[i],b[i]);
        }

        return t;
    }

    public int[] count(String s)
    {
        int[]t = new int[26];
        for(char ch : s.toCharArray())
        {
            t[ch-'a']++;
        }
        return t;
    }
}
