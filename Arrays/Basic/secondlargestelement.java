import java.util.Arrays;
import java.util.Scanner;

public class secondlargestelement {
  public static int[] getSecondOrderElements(int n, int[] a) {
    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;
    int[] ans = new int[2];
    Arrays.sort(a);
    for (int i = 0; i < n; i++) {
      if (a[i] > max1) {
        max2 = max1;
        max1 = a[i];
    }
  }
  ans[0] = max2;
  ans[1] = a[1];
  return ans;

  }

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }

    System.out.println(Arrays.toString(getSecondOrderElements(n, arr)));
    // getSecondOrderElements(n, arr);

  }
}
