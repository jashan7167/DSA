public class countgoodnumbers {
  private static final int mode = 1_000_000_007;
   static long apow(long x ,long n)
   {
    if(n==0)
    {
      return 1;
    }
    if(n%2==1)
    {
       return x * apow(x,n-1) % mode;
    }
    else
    {
      return apow(x*x % mode,n/2);
    }
   }
   public static int countgood(long n)
   {
    return (int)(apow(4*5,n/2) * (n%2==1?5:1) % mode);
   }
  public static void main(String[] args) {
    int n = 50;
    System.out.println(countgood(n));;

  }
}
