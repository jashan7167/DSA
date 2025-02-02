import java.util.Arrays;
import java.util.*;

class rotateimage {
  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void reverse(int[] arr) {
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      swap(arr, low, high);
      low++;
      high--;
    }
  }

  public static void rotate(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    // firstly taking a transpose is important
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < i; j++) {

        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
    //then reverse each of the array
    for (int arr[] : matrix) {
      reverse(arr);
    }
  }

  public static void main(String[] args) {
    int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

    int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
    reverse(arr);
    System.out.println(Arrays.toString(arr));
    rotate(mat);
    for (int arr1[] : mat) {
      System.out.println(Arrays.toString(arr1));
    }
  }
}