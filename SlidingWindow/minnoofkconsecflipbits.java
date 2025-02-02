class Solution {
  public int minKBitFlips(int[] nums, int k) {
    Deque<Integer> dq = new LinkedList<>();
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      while (!dq.isEmpty() && i > (dq.peekFirst() + k - 1)) {
        dq.removeFirst();
      }

      if ((nums[i] + dq.size()) % 2 == 0) {
        if (i + k > nums.length) {
          return -1;
        }
        res += 1;
        dq.addLast(i);
      }
    }

    return res;

  }
}