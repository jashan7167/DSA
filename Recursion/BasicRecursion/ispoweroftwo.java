public class ispoweroftwo{
  static boolean powtwo(int n)
  {
    //if remainder 1 is coming then false
    if(n<=0)
    {
     return false;
    }
    if(n==1)
    {
     return true;
    }
   if(n%2==1)
   {
    return false;
   }

   return powtwo(n/2);
  
  }
      public static void main(String[] args) {
        System.out.println(powtwo(3));
        
      }
}

