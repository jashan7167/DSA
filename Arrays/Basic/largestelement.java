import java.util.*;


public class largestelement {

  static int largestElement(int[] arr, int n) {
    int max = Integer.MIN_VALUE;

    for(int i = 0 ; i < n ; i++)
    {
      if(arr[i]>max)
      {
        max = arr[i];
      }
    }

    return max;
  }

  public static void main(String[] args) {
    
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n ; i++)
    {
      arr[i] = in.nextInt();
    }

    System.out.println(largestElement(arr, arr.length));


  }
}