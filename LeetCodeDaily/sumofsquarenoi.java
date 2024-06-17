class Solution {
    public boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (int)Math.sqrt(c); //for 5 it is 2
        
        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                left++;
            } else {
                right--;
            }
        }
        
        return false;
    }
}
