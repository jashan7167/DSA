class Solution {
    public String reversePrefix(String word, char ch) {
        int j = word.indexOf(ch);
        int i = 0;
        char[]str = word.toCharArray();
        while(i<j)
        {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
        String b = new String(str);
        return b;
    }
}