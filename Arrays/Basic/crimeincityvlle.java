import java.io.*;
import java.util.*;

class Solution {
  public static int max(int a , int b , int []arr)
    {
      int max = Integer.MIN_VALUE;
             for(int i = a-1 ; i <=b-1 ; i++)
             {
              if(arr[i]>max)
              {
                max = arr[i];
              }
             }
             return max;
    }

  public static void main(String[] args) {
    int n;
    int q;
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    q = sc.nextInt();
    int[] arr = new int[5];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int t,l,r,x;
    while(q>0)
    {
      t = sc.nextInt();
      if(t==1)
      {
        l = sc.nextInt();
        r = sc.nextInt();
        x = sc.nextInt();
        for(int i = l-1 ; i <=r-1 ; i++)
        {
          arr[i] = arr[i]+x;
        }
      }
      else
      {
        l = sc.nextInt();
        r = sc.nextInt();
        int max = max(l, r, arr);
        System.out.println(max);
      }
      q--;
    }
    sc.close();
    }
}