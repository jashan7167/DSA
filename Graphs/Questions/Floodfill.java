
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    while (T-- > 0) {
      String[] S1 = br.readLine().trim().split(" ");
      int n = Integer.parseInt(S1[0]);
      int m = Integer.parseInt(S1[1]);
      int[][] image = new int[n][m];
      for (int i = 0; i < n; i++) {
        String[] S2 = br.readLine().trim().split(" ");
        for (int j = 0; j < m; j++)
          image[i][j] = Integer.parseInt(S2[j]);
      }
      String[] S3 = br.readLine().trim().split(" ");
      int sr = Integer.parseInt(S3[0]);
      int sc = Integer.parseInt(S3[1]);
      int newColor = Integer.parseInt(S3[2]);
      Solution obj = new Solution();
      int[][] ans = obj.floodFill(image, sr, sc, newColor);
      for (int i = 0; i < ans.length; i++) {
        for (int j = 0; j < ans[i].length; j++)
          System.out.print(ans[i][j] + " ");
        System.out.println();
      }
    }
  }
}

// } Driver Code Ends

class Solution {
  public void dfs(int[][] img, int[][] ans, int row, int col, int newColor, int inicolor, int[] delRow, int[] delCol) {
    ans[row][col] = newColor;
    for (int i = 0; i < delCol.length; i++) {
      int nrow = row + delRow[i];
      int ncol = col + delCol[i];
      if (nrow >= 0 && nrow < img.length && ncol >= 0 && ncol < img[0].length && img[nrow][ncol] == inicolor &&
          ans[nrow][ncol] != newColor) {
        dfs(img, ans, nrow, ncol, newColor, inicolor, delRow, delCol);
      }

    }
  }

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int[][] ans = image;
    int inicolor = image[sr][sc];

    int[] delRow = { -1, 0, +1, 0 };
    int[] delCol = { 0, +1, 0, -1 };
    dfs(image, ans, sr, sc, newColor, inicolor, delRow, delCol);
    return ans;

  }
}