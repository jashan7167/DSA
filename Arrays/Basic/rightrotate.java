import java.util.Arrays;

public class rightrotate {

  public static void rightrotatearr(int[] arr, int n) {
    int l = arr.length;
    while (n > arr.length) {
      n = n - l;
    }

    int[] temp = new int[l - n];
    // copying elements in temp array less than l-n
    for (int i = 0; i < l - n; i++) {
      temp[i] = arr[i];
    }

    // moving the rest element to index zero to D
    for (int i = l - n; i < l; i++) {
      arr[i - (l - n)] = arr[i];
    }

    // now copy elements from temp from d to size in original array
    for (int i = 0; i < l - n; i++) {
      arr[i + n] = temp[i];
    }
  }

  public static void reverse(int arr[], int start, int end) {
    while (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }

  public static void optimalrot(int[] arr, int k) {
    k = k % arr.length;
    reverse(arr, 0, arr.length - 1);
    reverse(arr, 0, k - 1);
    reverse(arr, k, arr.length - 1);
  }

  public static void optimalleftrot(int[] arr, int k) {
    k = k % arr.length;
    reverse(arr, 0, arr.length - 1);
    reverse(arr, arr.length - k, arr.length - 1);
    reverse(arr, 0,k);
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5 };
    optimalrot(arr, 2);
    System.out.println(Arrays.toString(arr));
    int[] arr2 = { 1, 2, 3, 4, 5 };
    reverse(arr2, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr2));
    int[] arr3 = { 1, 2, 3, 4, 5 };
    optimalleftrot(arr3, 2);
    System.out.println(Arrays.toString(arr3));
  }
}
