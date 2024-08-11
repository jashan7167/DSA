class Solution {
  public int minimumPushes(String word) {
    int[] count = new int[26];

    for (char ch : word.toCharArray()) {
      count[ch - 'a']++;
    }
    int res = 0;
    int distinct = 0;
    Arrays.sort(count);
    for (int i = count.length - 1; i >= 0; i--) {
      if (count[i] > 0) {
        res += count[i] * (1 + distinct / 8);
        distinct++;
      }
    }

    return res;

  }
}