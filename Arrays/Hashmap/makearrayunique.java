import java.util.HashMap;

class Solution {
  public int minIncrementForUnique(int[] nums) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int j : nums) {
      hm.put(j, hm.getOrDefault(j, 0) + 1);
    }

    int idx = 0;
    int moves = 0;

    while (true) {
      boolean allUnique = true;
      for (int i = 0; i < nums.length; i++) {
        while (hm.get(nums[i]) > 1) {
          hm.put(nums[i], hm.get(nums[i]) - 1);
          nums[i]++;
          moves++;
          hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
      }
      for (int count : hm.values()) {
        if (count > 1) {
          allUnique = false;
          break;
        }
      }
      if (allUnique) {
        break;
      }
    }

    return moves;
  }
}
