class Solution {
    public boolean isCircularSentence(String sentence) {
		//2490 
        if(sentence.charAt(0)!=sentence.charAt(sentence.length()-1))
        {
            return false;
        }
        int n = sentence.length();
        for(int i=0;i < n;i++)
        {
            if(sentence.charAt(i)==' ')
            {
                char a = sentence.charAt(i-1);
                char b = sentence.charAt(i+1);
                if(a!=b)
                {   
                    return false;
                }
            }
        }

        return true;
    }
}
