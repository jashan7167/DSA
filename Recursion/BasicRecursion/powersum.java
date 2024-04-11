import java.math.*;
import java.util.Scanner;
import java.io.*;


class powersum
{
  public static int psum(int x ,int n,int cur)
  {
       if(Math.pow(cur,n)<x)
       {
        return psum(x,n,cur+1) + psum(x - (int)Math.pow(cur,n),n,cur+1);
       }
       else if(Math.pow(cur,n)==x)
       {
        return 1;
       }
       else
       {
        return 0;
       }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int x,n;
    x = sc.nextInt();
    n = sc.nextInt();

    if((x>1 && x<1000) && (n>=2 && n<=10))
    {
      int res = psum(x, n, 1);
        System.out.print(res);
    }
    else
    {
      System.out.println("Not in range");
    }
    sc.close();
    
  }
}