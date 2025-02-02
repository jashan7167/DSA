package ArrayQuestions;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
//        int n;
//        Scanner sc  = new Scanner(System.in);
//        n = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] =  sc.nextInt();
//        }
        int[] arr = {1,2,3,4,55,66,76};
        int target =55;
        int index = search(arr,target,0,arr.length-1);
        System.out.println("index = "+  index);
    }
    static int search(int[]arr, int target,int s,int e)
    {
        if(s>e)
        {
            return -1;
        }
        int mid = s + (e - s)/2;
        if(arr[mid]==target)
        {
            return mid;
        }
        if(target<arr[mid]) {
           return search(arr, target, s, mid-1);
        }
        return search(arr,target,mid+1,e);
    }
}
