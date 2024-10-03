class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String,Integer> hs = new HashMap<>();
        String[]str1 = s1.split(" ",0);
        String[]str2 = s2.split(" ",0);
        List<String> ans = new ArrayList<>();

        for(String a : str1)
        {
            if(hs.containsKey(a))
            {
                hs.put(a,hs.get(a)+1);
            }
            else
            {
                hs.put(a,1);
            }
        }

        for(String a : str2)
        {
            if(hs.containsKey(a))
            {
                hs.put(a,hs.get(a)+1);
            }
            else
            {
                hs.put(a,1);
            }
        }

        for(String key : hs.keySet())
        {
            if(hs.get(key)==1)
            {
                ans.add(key);
            }
        }

        String[]arr = new String[ans.size()];

        for(int i = 0 ; i < ans.size() ; i++)
        {
            arr[i] = ans.get(i);
        }        

        return arr;

    }
}
