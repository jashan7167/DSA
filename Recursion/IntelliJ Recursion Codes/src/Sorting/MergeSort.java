package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int [] arr = {8,3,4,12,5,6};
       int [] ans =  mergeSort(arr);
        System.out.println(Arrays.toString(ans));
    }

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;

        }
        int mid = arr.length / 2;
        //Arrays copy of range of method makes a new array from a specific range to another
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length]; //creating a combined array for the merge
        //two pointer algorithm
        int i = 0;
        int j = 0;
        int k = 0;

       while(i<first.length && j<second.length)
       {
           if(first[i]<second[j])
           {
               mix[k] = first[i];

               i++;
           }
           else
           {
               mix[k] = second[j];
               j++;
           }
           k++;
       }

       //it may be possible one of the arrays may not be complete
        while(i<first.length)
        {
            mix[k] = first[i];
            i++;
            k++;
        }
        while(j<second.length)
        {
            mix[k] = second[j];
            j++;
            k++;
        }

    return mix;
    }
}
