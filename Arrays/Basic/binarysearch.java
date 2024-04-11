
import java.util.*;


class bins
{

  private int[]arr;

  bins(int[]a)
  {
  
    this.arr = a;

  }


  public static int bs(bins b,int key)
   {
    int low = 0;
    int high = b.arr.length  - 1;
    int mid = 0;
     while(low<=high)
     {
      mid = (low+high)/2;
      if(b.arr[mid]==key)
      {
        return mid;
      }
      else if(b.arr[mid]<key)
      {
        low = mid + 1;
      }
      else if(b.arr[mid]>key)
      {
        high = mid - 1;
      }
     }
     return -1;
   }

  public static void main(String[] args) {
    
     bins b = new bins(new int[]{1,2,3,15,44,60,76,102,200,230,322,563});
     System.out.println(Arrays.toString(b.arr));
     System.out.println(b.bs(b, 102));
  }
}






