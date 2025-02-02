public class linearsearch {
  public static int linearSearch(int n, int num, int[] arr) {
    int idx = 0;
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == num) {
        if (count == 0) {
          idx = i;
          count++;
        } else {
          count++;
        }
      }
    }
    if (count == 0) {
      return -1;
    }
    return idx;
  }

  public static void main(String[] args) {
    System.out.println(linearSearch(4, 2, new int[] { 5, 2, 6, 2 }));

  }
}
