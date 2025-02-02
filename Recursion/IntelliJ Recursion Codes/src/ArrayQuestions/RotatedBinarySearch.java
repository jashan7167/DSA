package ArrayQuestions;

public class RotatedBinarySearch {
    public static void main(String[] args) {
            int[] arr = {5,6,7,8,9,1,2,3};
        System.out.println(binarysearch(arr,0,arr.length-1,8));
    }
    static int binarysearch(int[]arr,int start,int end,int key) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == key)
        {
            return mid;
        }

        if(arr[start]<=arr[mid]) //check to see if the first half is sorted or not
        {
            if(key>=arr[start] && key<=arr[mid])
            {
                return binarysearch(arr,start,mid-1,key);
            }
            else
            {
                return binarysearch(arr,mid+1,end,key);
            }
        }

        if(key>=arr[mid] && key<=arr[end])  //checks if second half is sorted or not
        {
            return binarysearch(arr,mid+1,end,key);
        }
        return binarysearch(arr,start,mid-1,key);
    }
}
