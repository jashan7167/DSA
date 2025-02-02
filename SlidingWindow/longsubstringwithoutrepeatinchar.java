public class longsubstringwithoutrepeatinchar {

}

class Solution {
  public int lengthOfLongestSubstring(String s) {
    // if the length of the string is zero

    if (s.length() == 0) {
      return 0;
    }
    int maxans = Integer.MIN_VALUE;

    Set<Character> set = new HashSet<>();
    // tc = O(N) + SC = O(256) for hashmap
    int l = 0;
    // outerloop for traversing the right pointer
    for (int r = 0; r < s.length(); r++) {
      if (set.contains(s.charAt(r))) {
        // move l to the last seen index of char at r + 1
        while (l < r && set.contains(s.charAt(r))) {
          set.remove(s.charAt(l));
          l++;
        }
      }
      set.add(s.charAt(r));
      maxans = Math.max(maxans, r - l + 1);

    }

    return maxans;

  }

}