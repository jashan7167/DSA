class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
    int l1 = nums1.length;
    int l2 = nums2.length;
    ArrayList<Integer> ar = new ArrayList<Integer>();
    int i = 0;
    int j = 0;
    Arrays.sort(nums1);
    Arrays.sort(nums2);

    while (i < l1 && j < l2) {
      if (nums1[i] < nums2[j]) {
        i++;
      } else if (nums1[i] > nums2[j]) {
        j++;
      } else {
        ar.add(nums1[i]);
        i++;
        j++;
      }
    }
    int[] ans = new int[ar.size()];

    for (int l = 0; l < ar.size(); l++) {
      ans[l] = ar.get(l);
    }
    return ans;

  }
}