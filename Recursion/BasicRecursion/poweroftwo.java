public class poweroftwo {


static boolean ispoweroftwo(int num,int n)
{
  if(num==n)
  {
    return true;
  }
}

  else if(n>num)
  {
    return false;
  }
  else
  {
    return ispoweroftwo(num,n*2);
  }
}

public static void main(String[] args) {
  
int n = 36;
System.out.println(ispoweroftwo(n,2));
}