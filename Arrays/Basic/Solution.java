import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    int n;
    int q;
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    q = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    while(q>0)
    {
      int a,b;
      a = sc.nextInt();
      b = sc.nextInt();
      int sum = 0;
      for(int i = a-1 ; i <=b-1; i++)
      {
        sum+=arr[i];
      }
      System.out.println(sum);
      q--;
    }
  }
}