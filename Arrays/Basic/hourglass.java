import java.util.*;

public class hourglass {

  static int hourglasssum(int rows,int columns,List<Integer> arr)
  {

    int max_sum = Integer.MIN_VALUE;

    if (rows < 3 || columns < 3) {
        System.out.println("Not possible");
        System.exit(0);
    }

    for (int i = 0; i < rows-1 ; i++) {
        for (int j = 0; j < columns-1; j++) {
            // max_sum = Math.max(max_sum, sum);
        }
    }

    return max_sum;
    }

  public static void main(String[] args) {

  }
}
