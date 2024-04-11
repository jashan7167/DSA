public class sumofdigits {

  static int sd(int n)
  {
    if(n==0)
    {
      return 0;
    }
    else
    {
     int rem = n%10;  //takes rem with each call
      return rem + sd(n/10); //adds the rem with the divided number each time it gets smaller new remainders gets summed up
    }
  }
  public static void main(String[] args) {
    System.out.println(sd(12345));
  }
}
