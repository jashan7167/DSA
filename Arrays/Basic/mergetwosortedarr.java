import java.util.*;

class Solution {
  public static List<Integer> sortedArray(int[] a, int[] b) {
    List<Integer> ls = new ArrayList<Integer>();
    int i = 0;
    int j = 0;

    while (i < a.length || j < b.length) {
      if (a[i] < b[j]) {
        ls.add(a[i]);
        i++;
      } else {
        ls.add(b[j]);
        j++;
      }
    }

    for (; i < a.length; i++) {
      ls.add(a[i]);
    }

    for (; j < b.length; j++) {
      ls.add(a[j]);
    }

    return ls;
  }

  public static void main(String[] args) {
    System.out.println(sortedArray(new int[] { 1, 2, 3, 4, 6 }, new int[] { 2, 3, 5 }));
  }
}