import static java.util.stream.Collectors.counting;

import java.util.Arrays;

public class movezeros {
  public static void movezeros(int[] arr) {
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        count++;
      }
    }
    System.out.println(count);
    int i = 0;
    while (i != count) {
      for (int j = 0; j < arr.length-1; j++) {
        if (arr[j] == 0) {
          int temp = arr[j + 1];
          arr[j + 1] = 0;
          arr[j] = temp;
        }
      }
      i++;
    }
  }

  public static void main(String[] args) {
    int [] arr = {0,1,0,3,12};
    movezeros(arr);
    System.out.println(Arrays.toString(arr));
  }
}
