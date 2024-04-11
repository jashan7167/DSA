
import java.util.Arrays;

public class maze {
  static int countpath(int r, int c) {
    if (r == 1 || c == 1) {
      return 1;
    }
    int left = countpath(r - 1, c);
    int diag = countpath(r - 1, c - 1);
    int right = countpath(r, c - 1);
    return left + diag + right;
  }

  static void printpath(int r, int c) {
    if (r == 1 || c == 1) {
      if (r == 1) {
        for (int i = c; i >= 1; i--) {

          if (i == 1) {
            System.out.println(String.format("(%d,%d)", r, i));
          } else {
            System.out.print(String.format("(%d,%d)->", r, i));
          }
        }
      } else if (c == 1) {
        for (int i = r; i >= 1; i--) {

          if (i == 1) {
            System.out.println(String.format("(%d,%d)", i, c));
          } else {
            System.out.print(String.format("(%d,%d)->", i, c));
          }
        }
      }
      return;
    }
    System.out.print(String.format("(%d,%d)->", r, c));
    printpath(r - 1, c);
    printpath(r, c - 1);

  }

  static void printpath2(String s, int r, int c) {
    if (r == 1 && c == 1) {
      System.out.println(s);
      return;
    }

    if (r > 1) {
      printpath2(s + 'D', r - 1, c);
    }

    if (c > 1) {
      printpath2(s + 'R', r, c - 1);
    }
  }

  static void printpathdiagnol(String s, int r, int c) {
    if (r == 1 && c == 1) {
      System.out.println(s);
      return;
    }

    if (r > 1 && c > 1) {
      printpathdiagnol(s + 'V', r - 1, c - 1);
    }
    if (r > 1) {
      printpathdiagnol(s + 'D', r - 1, c);
    }

    if (c > 1) {
      printpathdiagnol(s + 'R', r, c - 1);
    }
  }

  static void pathRestrictions(String s, boolean[][] maze, int r, int c) {
    if (r == maze.length - 1 && c == maze[0].length - 1) {
      System.out.println(s);
      return;
    }
    // this is for the obstacle in the maze
    if (!maze[r][c]) {
      return;
    }
    if (r < maze.length - 1) {
      pathRestrictions(s + 'D', maze, r + 1, c);
    }

    if (c < maze[0].length - 1) {
      pathRestrictions(s + 'R', maze, r, c + 1);
    }
  }

  static void allpathmat(String s, boolean[][] maze, int[][] path, int r, int c, int step) {
    if (r == maze.length - 1 && c == maze[0].length - 1) {
      path[r][c] = step;
      for (int[] arr : path) {
        System.out.println(Arrays.toString(arr));
      }
      System.out.println("Finished");
      return;
    }
    // this is for the obstacle in the maze
    if (!maze[r][c]) {
      return;
    }
    // i am considering this block in my path
    maze[r][c] = false;
    path[r][c] = step;

    if (r < maze.length - 1) {
      allpathmat(s + 'D', maze, path, r + 1, c, step + 1);
    }

    if (c < maze[0].length - 1) {
      allpathmat(s + 'R', maze, path, r, c + 1, step + 1);
    }
    if (r > 0) {
      allpathmat(s + 'U', maze, path, r - 1, c, step + 1);
    }
    if (c > 0) {
      allpathmat(s + 'L', maze, path, r, c - 1, step + 1);
    }
    // this line is where the function will be over
    // so before the function gets removed , also remove the the changes made by the
    // recursion calls
    // this is where i am doing backtracking
    maze[r][c] = true;
    path[r][c] = 0;

  }

  public static void main(String[] args) {
    System.out.println("No of ways we can go from point A to point B");
    System.out.println(countpath(3, 3));
    System.out.println("Literal points to go");
    printpath(3, 3);
    System.out.println("Directions:");
    printpathdiagnol(" ", 3, 3);
    boolean[][] board = {
        { true, true, true },
        { true, false, true },
        { true, true, true }
    };
    boolean[][] maze = {
        { true, true, true },
        { true, true, true },
        { true, true, true }
    };
    int[][] path = new int[3][3];

    System.out.println("Maze with obstacles");
    pathRestrictions("", board, 0, 0);
    System.out.println("All paths in the maze");
    allpathmat("", maze,path, 0, 0, 1);
  }

}
