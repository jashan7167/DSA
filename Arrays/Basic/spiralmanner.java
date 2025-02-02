import java.util.*;

class Solution {
  //bruteforce
  public List<Integer> spiralOrder(int[][] matrix) {
       List<Integer> l = new ArrayList<Integer>();
    int col = matrix[0].length;
    int row = matrix.length;
    int i = 0;
    int j = 0;
    for(j = 0 ; j < col-1 ; j++)
    {
      l.add(matrix[i][j]);
    }
    System.out.println(i);
    System.out.println(j);
    for(i = 0 ; i < row-1; i++)
    {
      l.add(matrix[i][j]);
    }

    System.out.println(i);
    System.out.println(j);
    for(;j>=0; j--)
    {
      l.add(matrix[i][j]);
    }
    i--;
    j++;
    System.out.println(i);
    System.out.println(j);

    for(;j<col-1;j++)
    {
      l.add(matrix[i][j]);
    }
    return l;
    }

    //optimal solution
    public List<Integer> spiralOrder(int[][] matrix) {
      List<Integer> l = new ArrayList<Integer>();
      int col = matrix[0].length;
      int row = matrix.length;
      int top = 0;
      int left = 0;
      int right = col - 1;
      int bottom = row - 1;
      // the bottom,left,right,top are changed as to make smaller and smaller matrix
      // which we can spiral upon until top<=bottom and left<=right which is the
      // ending condition
      while (top <= bottom && left <= right) {
        // left to right
        for (int i = left; i <= right; i++) {
          l.add(matrix[top][i]);
        }
        top++;
        // top to bottom
        for (int i = top; i <= bottom; i++) {
          l.add(matrix[i][right]);
        }
        right--;

        // right to left
        if (top <= bottom) { //we have to check as if there is no second row theres one column only
          for (int i = right; i >= left; i--) {
            l.add(matrix[bottom][i]);
          }
          bottom--;
        }
        if (left <= right) {  //if there is only one column then we have to check it

          for (int i = bottom; i >= top; i--) {
            l.add(matrix[i][left]);
          }
          left++;
        }

      }
      return l;
    }
  }
