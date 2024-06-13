import java.io.*;

class Solution {
  public int heightChecker(int[] heights) {
    int[] temp = heights.clone();
    Arrays.sort(heights);
    int count = 0;
    for (int i = 0; i < heights.length; i++) {
      if (heights[i] != temp[i]) {
        count++;
      }
    }

    return count;

  }
}