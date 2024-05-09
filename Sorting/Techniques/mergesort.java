package Techniques;
import java.util.Arrays;

public class mergesort {

  static int[] ms(int[] arr) {
    // until the array goes to the end and starting merge and sort up until the root
    // node
    if (arr.length == 1) {
      return arr;
    }

    int mid = arr.length / 2;

    int[] left = ms(Arrays.copyOfRange(arr, 0, mid));
    int[] right = ms(Arrays.copyOfRange(arr, mid, arr.length));

    // now see first the recursion calls go to the lefts of the main array and goes
    // to the end
    // and when base condition is encountered the array is returned and the right
    // function call will be executed to create a tree branch / something like this
    // /
    // /\
    // and then after that merge will be called at the node where the branch emerged
    // to merge both of the arrays
    return merge(left, right);
  }

  static int[] merge(int[] left, int[] right) {
    int[] combined = new int[left.length + right.length];

    int i = 0;
    int j = 0;
    int k = 0;

    while (i < left.length && j < right.length) {
      if (left[i] < right[j]) {
        combined[k] = left[i];
        k++;
        i++;
      } else {
        combined[k] = right[j];
        k++;
        j++;
      }
    }

    if(i<left.length)
    {
       for(;i<left.length;i++,k++)
       {
        combined[k] = left[i];
       }
    }
    else
    {
      for(;j<right.length;j++,k++)
      {
        combined[k] = right[j];
      }
    }

    return combined;
  }

  public static void main(String[] args) {
    int [] arr = {2,1,3,5,4,8,6};
    System.out.println(Arrays.toString(ms(arr)));

  }
}