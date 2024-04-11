public class countzeros {

  static int count(int n,int count)
  {
    if(n==0) //base condition
    {
      return count;
    }
    else
    {
      if(n%10==0) //if it gets divided by 10 it means it had zero 
      {
        count++;
      }
      return count(n/10,count); //remove the last digit
    }
  }
  public static void main(String[] args) {
        System.out.println(count(1020340560,0));
  }
}
