import java.util.*;

class Solution {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    List<Integer> greater = new LinkedList<Integer>();
    int index = 0;
    boolean flag = false;
    Stack<Integer> st = new Stack<Integer>();
    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums2.length; j++) {
        if (nums1[i] == nums2[j]) {

          for (int k = nums2.length - 1; k > j; k--) {
            st.push(nums2[k]);
          }
          while (!st.isEmpty()) {
            int pop = st.pop();
            if (pop > nums2[j]) {
              greater.add(pop);
              flag = true;
              break;
            }
          }
          if (!flag) {
            greater.add(-1);
          }
          while (!st.isEmpty()) {
            st.pop();
          }
          flag = false;
        }
      }
    }
    int[] array = new int[greater.size()];
    for (Integer num : greater) {
      array[index++] = num;
    }

    return array;

  }
}