import java.util.ArrayList;
import java.util.List;
public class permutation {

  public static void main(String[] args) {
    permutations("", "abc");
    System.out.println(permutationa("","abc"));
    System.out.println(permutationc("","abc"));
  }

  static void permutations(String p, String up) {
    if (up.isEmpty()) {
      System.out.println(p);
      return;
    }
    char ch = up.charAt(0);
    for (int i = 0; i <= p.length(); i++) {
      String f = p.substring(0, i);
      String s = p.substring(i, p.length());
      permutations(f + ch + s, up.substring(1));      
    }
  }
  
  static ArrayList<String> permutationa(String p, String up) {

    if (up.isEmpty()) {
      ArrayList<String> al1 = new ArrayList<>();
      al1.add(p);
       return al1;
    }
    ArrayList<String> al = new ArrayList<String>();
    char ch = up.charAt(0);
    for (int i = 0; i <= p.length(); i++) {
      String f = p.substring(0, i);
      String s = p.substring(i, p.length());
      al.addAll(permutationa(f+ch+s, up.substring(1)));
  }

  //at each leaf node i return a arraylist which at the root node is merged with all the other arraylists from other leaf nodes with al.addAll when all the function calls are finished a arraylist al is returned

  return al;
}

static int permutationc(String p, String up) {
  int count = 0;
  if (up.isEmpty()) {
     return 1;
  }
  char ch = up.charAt(0);
  for (int i = 0; i <= p.length(); i++) {
    String f = p.substring(0, i);
    String s = p.substring(i, p.length());
    count= count + permutationc(f + ch + s, up.substring(1));
  }


  return count;

}
}