import java.util.Arrays;

public class setmatrixzero {
  public static void setZeros(int[][] matrix) {
    int n = matrix[0].length;
    int m = matrix.length;
    boolean isZero = false;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          isZero = true;
          for (int k = 0; k < n; k++) {
            if (matrix[i][k] == 0) {
              continue;
            } else {
              System.out.println(matrix[i][k]);

              matrix[i][k] = Integer.MIN_VALUE / 2; // row same columns to zero
            }
          }
          for (int l = 0; l < m; l++) {
            if (matrix[l][j] == 0) {
              continue;
            } else {
              System.out.println(matrix[l][j]);
              matrix[l][j] = Integer.MIN_VALUE / 2; // column same rows to zero
            }
          }
        }
      }
    }
    if (isZero == true) {

      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (matrix[i][j] == Integer.MIN_VALUE / 2) {
            matrix[i][j] = 0;
          }
        }
      }
    }

  }

  public static void main(String[] args) {
    int[][] arr = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
    setZeros(arr);
    int n = arr[0].length;
    int m = arr.length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }
    
  }
}
