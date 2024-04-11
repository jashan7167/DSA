class skipachar {
  static void skip(String p, String u) {
    if (u.isEmpty()) {
      System.out.println(p);
      return;
    }
    char ch = u.charAt(0);
    if (ch == 'a') {
      skip(p, u.substring(1)); // substring from index no: 1
    } else {
      p = p + ch;
      skip(p, u.substring(1));
    }
  }

  static String skipa(String u) {
    if (u.isEmpty()) {
      return " ";
    }
    char ch = u.charAt(0);
    if (ch == 'a') {
      return skipa(u.substring(1)); // substring from index no: 1
    } else {

      return ch + skipa(u.substring(1));
    }
  }

  static String skipApple(String u) {
    if (u.isEmpty()) {
      return " ";
    }
    if (u.startsWith("Apple") || u.startsWith("apple")) {

      return skipApple(u.substring(5)); // sending the string where apple ends
    } else {

      return u.charAt(0) + skipApple(u.substring(1)); // otherwise same take character and combine recursively with // other characters
    }
  }
  static String skipAppNotApple(String u) {
    if (u.isEmpty()) {
      return " ";
    }
    if (u.startsWith("app") && !u.startsWith("apple")) {

      return skipAppNotApple(u.substring(3)); // sending the string where apple ends
    } else {

      return u.charAt(0) + skipAppNotApple(u.substring(1)); // otherwise same take character and combine recursively with // other characters
    }
  }

  public static void main(String[] args) {
    String p = ""; // strings immutable in java cannot change thats why new object in recursion
                   // each function call then print at last and then return
    skip(p, "abbaccd");
    System.out.println(p);

    System.out.println(skipa("abbbcabbabba"));

    System.out.println(skipApple("adsadsApplebfg"));
    System.out.println(skipAppNotApple("adsadsappbfg")); //skip a app which is not actually apple

  }
}
