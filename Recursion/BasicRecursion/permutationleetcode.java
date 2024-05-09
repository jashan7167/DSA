import java.util.*;

class Solution {
  public List<List<Integer>> permute(int[] nums) {
    boolean[] freq = new boolean[nums.length];
    List<Integer> ds = new ArrayList();
    List<List<Integer>> ans = new ArrayList();

    recurper(nums, ds, ans, freq);
    return ans;

  }

  public void recurper(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] freq) {
    if (ds.size() == nums.length) {
      ans.add(new ArrayList<>(ds));
    }

    for (int i = 0; i < nums.length; i++) {
      if (!freq[i]) {
        freq[i] = true;
        ds.add(nums[i]);
        recurper(nums, ds, ans, freq);
        ds.remove(ds.size() - 1);
        freq[i] = false;
      }
    }

  }

}