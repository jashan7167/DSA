import java.util.Arrays;

class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = 0;
    int j = 0;
    int[] nums1c = Arrays.copyOf(nums1, m);
    int k = 0;
    if (m == 0) {
      for (int l = 0; l < n; l++) {
        nums1[k] = nums2[l];
        k++;
      }
      return;
    }
    while (i < m && j < n) {

      if (nums1c[i] <= nums2[j]) {
        nums1[k] = nums1c[i];
        i++;
        k++;
      } else {
        nums1[k] = nums2[j];
        j++;
        k++;
      }
    }
    while (i < m) {
      nums1[k] = nums1c[i];
      i++;
      k++;
    }
    while (j < n) {
      nums1[k] = nums2[j];
      j++;
      k++;
    }

  }
}