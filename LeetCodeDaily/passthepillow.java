class Solution {
  public int passThePillow(int n, int time) {
    int i = 1;
    boolean rev = true;
    while (time != 0) {
      if (i == n || i == 1) {
        rev = !rev;
      }
      i = (rev == false) ? i + 1 : i - 1;
      time--;
    }
    return i;

  }
}