class Solution {
  public int scoreOfString(String s) {
    int score = 0;
    char[] ans = s.toCharArray();
    for (int i = 0; i < ans.length - 1; i++) {
      score += Math.abs((ans[i] - '0') - (ans[i + 1] - '0'));
    }

    return score;
  }
}