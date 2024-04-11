import java.util.ArrayList;

class subsequences {

  static void subsequence(String p,String up)
  {
    if(up.isEmpty())
    {
      System.out.println(p);
      return;
    }

    char ch = up.charAt(0);

    subsequence(p+ch,up.substring(1));
    subsequence(p, up.substring(1));
  }

  //print subsequences with ascii values
  // static void subsequenceascii(String p,String up)
  // {
  //   if(up.isEmpty())
  //   {
  //     System.out.println(p);
  //     return;
  //   }

  //   char ch = up.charAt(0);

  //   subsequence(p+ch,up.substring(1));
  //   subsequence(p, up.substring(1));
  // }

  static ArrayList<String> subseq(String p,String up)
  {
        if(up.isEmpty())
        {
          ArrayList<String> list = new ArrayList<>();
          list.add(p);
          return list;
        }

    char ch = up.charAt(0);

    ArrayList<String> left = subseq(p+ch,up.substring(1)); //stores the answer from the left
   ArrayList<String> right = subseq(p, up.substring(1)); //stores the answer from the right
   left.addAll(right); //happens at the rootnode

   return left;

  }
  public static void main(String[] args) {
      subsequence("", "abc");

      System.out.println(subseq("","abc"));

    //  System.out.println(subsequenceascii("","abc"););



  }
}
