class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutes = new ArrayList<>();

        for(String time : timePoints)
        {
            int hr = 10*(time.charAt(0)-'0') + (time.charAt(1)-'0');
            int min = 10*(time.charAt(3)-'0') + (time.charAt(4)-'0');
            int totmin = 60*hr + min;
            minutes.add(totmin);
        }
        Collections.sort(minutes);
        int min = Integer.MAX_VALUE;
        //as we have sorted the list check for the adjacent elements
        for(int i = 1 ; i < minutes.size() ; i++)
        {
            min = Math.min(min,minutes.get(i)-minutes.get(i-1));
        }
        int n = minutes.size()-1;
        //calculate the wrap around time
        min = Math.min(min,1440-(minutes.get(n)-minutes.get(0)));
        return min;
    }
}
