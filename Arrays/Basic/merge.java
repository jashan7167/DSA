import java.util.ArrayList;
import java.util.List;

public class merge {
  public static List<Integer> sortedArray(int[] a, int[] b) {
    List<Integer> ls = new ArrayList<Integer>();
    int i = 0;
    int j = 0;

    while (i < a.length && j < b.length) {
      if (ls.contains(a[i])) {
        i++;
      } else if (ls.contains(b[j])) {
        j++;
      } else if (a[i] < b[j]) {
        ls.add(a[i]);
        i++;
      } else if (a[i] == b[j]) {
        ls.add(a[i]);
        i++;
        j++;
      } else {
        ls.add(b[j]);
        j++;
      }
    }

    for (; i < a.length; i++) {
      if (!ls.contains(a[i])) {
        ls.add(a[i]);
      }
    }

    for (; j < b.length; j++) {
      if (!ls.contains(b[j])) {
        ls.add(b[j]);
      }
    }

    return ls;
  }

  public static void main(String[] args) {
    System.out.println(sortedArray(new int[] { 2, 2, 4 }, new int[] { 3, 3, 3, 15, 16, 17 }));
  }

}
