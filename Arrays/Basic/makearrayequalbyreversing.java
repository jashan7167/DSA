class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[]freq = new int[1001];
        for(int n : arr)
        {
            freq[n]++;
        }
        for(int n : target)
        {
            freq[n]--;
        }
        for(int el : freq)
        {
            if(el!=0) return false;
        }
        return true;
    }
}