class Solution {
  public int[] frequencySort(int[] nums) {
    // as the constraints say there are no like -100 to 100
    int[] freq = new int[201];
    List<Integer> list = new ArrayList<>();
    // count the frequency of the each element
    for (int num : nums) {
      freq[num + 100] += 1;
      list.add(num);
    }
    // sort the list with a custom comparator
    Collections.sort(list, (a, b) -> {
      return freq[a + 100] == freq[b + 100] ? b - a : freq[a + 100] - freq[b + 100];
    });

    for (int i = 0; i < nums.length; i++) {
      nums[i] = list.get(i);
    }

    return nums;
  }
}