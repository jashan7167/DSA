import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class superiorelement {
  public static List<Integer> superiorElements(int[] a) {
    List<Integer> l = new ArrayList<>();

    int j;
    for (int i = 0; i < a.length; i++) {
      int num = a[i];
      for (j = i + 1; j < a.length; j++) {
        if (num < a[j]) {
          break;
        }
      }
      System.out.println("j: " + j);
      System.out.println("i: " + i);
      if (j == (a.length) && !l.contains(num)) {
        System.out.println("ed");
        l.add(num);
      }
    }
    Collections.sort(l);
    return l;
  }

  public static List<Integer> superiorElements2(int[] a) {
    List<Integer> l = new ArrayList<>();
    int max = Integer.MIN_VALUE;
    for (int i = a.length - 1; i >= 0; i--) {
      if (a[i] > max) {
        l.add(a[i]);
        max = a[i];
      }
    }
    Collections.sort(l);
    return l;
  }

  public static void main(String[] args) {
    System.out.println(superiorElements2(new int[] { 1, 2, 2, 1 }));
  }
}
