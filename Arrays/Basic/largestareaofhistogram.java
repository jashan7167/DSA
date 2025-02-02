public class largestareaofhistogram {
  public static void main(String[] args) {
    int[] arr = { 2, 1, 5, 6, 2, 3 };
    int maxar = Integer.MIN_VALUE;

    for (int i = 0; i < arr.length; i++) {
      System.out.println(i);
      int area = 0;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] > arr[i] && j == arr.length - 1) {
          area = (j - i + 1) * arr[i];
          break;
        } else if (j == arr.length - 1) {
          area = arr[i];
        } else if (arr[j] < arr[i]) {
          if (j - i == 1) {
            area = arr[i];
          } else {
            area = (j - i) * arr[i];
          }
          break;
        }

      }
      System.out.println(area + "yo1");
      for (int j = i - 1; j >= 0; j--) {
        if (arr[j] < arr[i] || j == 0) {
          if (j == 0) {
            area += (i - j - 1) * arr[i];
          }
          if (i - j == 1) {
            area += 0;
          } else {
            area += (i - j - 1) * arr[i];
          }
          break;
        }

      }
      System.out.println(area + "yo2");
      maxar = Math.max(maxar, area);
    }
    System.out.println(maxar);

  }
}
