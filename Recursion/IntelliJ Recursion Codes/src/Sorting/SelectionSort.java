package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int [] arr = {4,3,2,1};
        selection(arr,arr.length,0,0);
        System.out.println(Arrays.toString(arr));


    }

    static void selection(int[] arr, int r, int c,int max) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            //print until it is equal to the column
            if (arr[c] > arr[max]) {
                 selection(arr,r,c+1,c);
            }
            else
            {
                selection(arr, r, c + 1,max);
            }

        } else {
            //reduce the row and move to the new line
            int temp = arr[max];
            arr[max] = arr[r-1];
            arr[r-1] = temp;
            selection(arr, r - 1, 0,0);
        }
    }

}
