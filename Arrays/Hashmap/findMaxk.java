class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int largestk = -1;
        for (int num : nums) {
            if (num > 0 && hs.contains(-num)) {
                largestk = Math.max(largestk, num);
            }
            if (num < 0 && hs.contains(-num)) {
                largestk = Math.max(largestk, -num);
            }
            hs.add(num);
        }
        if (largestk == -1) {
            return -1;
        } else {
            return largestk;
        }
    }
}