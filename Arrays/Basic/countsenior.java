class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String val : details)
        {
            int age = Integer.parseInt(val.substring(11,13));
            if(age>60)
            {
                count++;
            }
        }
        return count;
    }
}
