class Solution {
  public int rangeSum(int[] nums, int n, int left, int right) {
    List<Integer> subarraysum = new ArrayList<Integer>();

    for (int i = 0; i < nums.length; i++) {
      subarraysum.add(nums[i]);
      int sum = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        sum += nums[j];
        subarraysum.add(sum);
      }
    }
    Collections.sort(subarraysum);
    double res = 0;
    for (int i = left - 1; i <= right - 1; i++) {
      res += subarraysum.get(i);
    }
    res = res % (1e9 + 7);
    return (int) res;
  }
}