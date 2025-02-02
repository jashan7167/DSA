
import java.util.*;

class Solution {
  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int j : arr1) {
      if (hm.containsKey(j)) {
        hm.put(j, hm.get(j) + 1);
      } else {
        hm.put(j, 1);
      }
    }
    int[] ans = new int[arr1.length];
    int idx = 0;
    for (int k : arr2) {
      while (hm.get(k) > 0) {
        ans[idx] = k;
        idx++;
        hm.put(k, hm.get(k) - 1);
      }
      hm.remove(k);
    }
    int[] remaining = new int[arr1.length - idx];
    int index = 0;
    for (int j : arr1) {
      if (hm.containsKey(j)) {
        while (hm.get(j) > 0) {
          remaining[index] = j;
          index++;
          hm.put(j, hm.get(j) - 1);
        }
        hm.remove(j);
      }
    }

    Arrays.sort(remaining);
    for (int j : remaining) {
      ans[idx] = j;
      idx++;
    }

    return ans;
  }

}