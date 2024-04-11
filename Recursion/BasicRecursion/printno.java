public class printno {
  static void print(int n)
  {
    if(n==0)
    {
      return ; //base condition
    }
    else
    {
      System.out.println(n);
      print(n-1);
    }
  }
    static void printrev(int n)
    {
      if(n==0)
      {
        return ; //base condition (will return to the main function)
      }
      else
      {
        printrev(n-1); //no need to do return the f clause when encounters 0 it will automatically return 0 to all the function calls
        System.out.println(n);
      }
    }

  public static void main(String[] args) {
    printrev(5); //returning phase print
    System.out.println();
    print(5); //calling phase print
  }
}
