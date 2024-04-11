

import java.util.ArrayList; 
import java.util.List;

class phonenocombination {
  static void pad(String p, String u) {
    if (u.isEmpty()) {
      System.out.println(p);
      return;
    }
    // convert this into an integer
    // this will convert '2' into 2 getting an equivalent integer value by
    // substracting ascii value of 0
    int dig = u.charAt(0) - '0';

    for (int i = (dig - 1) * 3; i < (dig * 3); i++) {
      char ch = (char) ('a' + i);
      pad(p + ch, u.substring(1));
    }

  }
  // static ArrayList<Integer> pad2(String p, String u) {
  //   if (u.isEmpty()) {
  //     ArrayList ar = new ArrayList<>();
  //     ar.add(p);
  //     return ar;
  //   }
  //   // convert this into an integer
  //   // this will convert '2' into 2 getting an equivalent integer value by
  //   // substracting ascii value of 0
  //   int dig = u.charAt(0) - '0';
  //   ArrayList<Integer> ans = new ArrayList<>();
  //   for (int i = (dig - 1) * 3; i < (dig * 3); i++) {
  //     char ch = (char) ('a' + i);
  //     ans.addAll(pad2(p+ch, u.substring(1)));
  //   }
  //   return ans;
  // }
  // public List<String> pad3(String digits) {
  //   if (digits.isEmpty()) {
  //     List<String>list = new ArrayList<String>();
  //     list.add();
  //     return list;
  //   }
  //   // convert this into an integer
  //   // this will convert '2' into 2 getting an equivalent integer value by
  //   // substracting ascii value of 0
  //   int dig = digits.charAt(0) - '0';
  //   List<Integer> ans = new ArrayList<>();
  //   for (int i = (dig - 1) * 3; i < (dig * 3); i++) {
  //     char ch = (char) ('a' + i);
  //     dig.addAll(pad2(p+ch, u.substring(1)));
  //   }
  //   return ans;
  // }

  public static  List<String> letterCombinations(String digits) {
    List<String> ls = new ArrayList<String>();
    if(digits.length()==0)
    {
      return ls;
    }
    else if(digits.length()==2)
    {
      int size1 = (digits.charAt(0) - '0') * 3 - 3;
      int size2 = (digits.charAt(1) - '0') * 3 - 3;
     if(digits.charAt(0)=='7' || digits.charAt(0)==9)
     {
      size1++;
     }
     else if(digits.charAt(1)=='7' || digits.charAt(1)=='9')
     {
      size2++;
     }
      String s = "";
      for (int i = ((digits.charAt(0) - '0') * 3) - 6; i <size1; i++) {
        char ch = (char)('a' + i);
        for (int j = ((digits.charAt(1) - '0') * 3) - 6; j <size2; j++) {
          char ch2 = (char) ('a' + j);
          ls.add(s+ch +ch2);
          s ="";
        }
        s = "";
      }
      return ls;
    }
    else
    {
      int size1 = (digits.charAt(0) - '0') * 3 - 3;
      if (digits.contains("9") || digits.contains("7")) {
        size1++;
      }
      
      String s = "";
      for (int i = ((digits.charAt(0) - '0') * 3) - 6; i <size1; i++) {
        char ch = (char)('a' + i);
        ls.add(s+ch);
        s="";
      }
      return ls;
    }

  }

  public static void main(String[] args) {
    pad("", "23");
    System.out.println("New method");
    System.out.println(letterCombinations("23"));
   
  }
}
