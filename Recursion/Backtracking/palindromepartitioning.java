import java.util.*;

class Solution {

  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    backtrack(s, 0, new ArrayList<>(), result);
    return result;

  }

  public void backtrack(String s, int start, List<String> path, List<List<String>> res) {
    if (start == s.length()) {
      res.add(new ArrayList<>(path));
      return;
    }
    for (int end = start + 1; end <= s.length(); end++) {
      if (isPalindrome(s, start, end - 1)) {
        path.add(s.substring(start, end));
        backtrack(s, end, path, res);
        path.remove(path.size() - 1);
      }
    }

  }

  private boolean isPalindrome(String s, int left, int right) {
    while (left < right) {
      if (s.charAt(left++) != s.charAt(right--)) {
        return false; 
      }
    }
    return true;
  }
}