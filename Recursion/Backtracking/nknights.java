class Nknights {
  public static void main(String[] args) {
    int n = 4;
    boolean[][] board = new boolean[n][n];
    knights(board, 0, 0, 4);
  }

  public static void knights(boolean[][] board, int row, int col, int knights) {
    // condition when you found the answer
    if (knights == 0) {
      display(board);
      System.out.println();
      return;
    }
    // condition for out of bounds
    if (col == board.length) {
      knights(board, row + 1, 0, knights);
      return;
    }
    if (row == board.length - 1 && col == board.length - 1) {
      return;
    }
    // out of bounds for the col we need to switch to the next row
    // if it is safe to put the knight then only put it onto the next column
    // otherwise just go ahead not reducing the knights
    if (isSafe(board, row, col)) {
      board[row][col] = true;
      knights(board, row, col + 1, knights - 1);
      board[row][col] = false;
    }

    knights(board, row, col + 1, knights);
  }

  public static boolean isSafe(boolean[][] board, int row, int col) {
    if (isValid(board, row - 2, col - 1) && board[row - 2][col - 1]) {
      return false;
    }
    if (isValid(board, row - 2, col + 1) && board[row - 2][col + 1]) {
      return false;
    }
    if (isValid(board, row - 1, col + 2) && board[row - 1][col + 2]) {
      return false;
    }
    if (isValid(board, row - 1, col - 2) && board[row - 1][col - 2]) {
      return false;
    }
    return true;
  }

  // donot repeat yourself hence created
  static boolean isValid(boolean[][] board, int row, int col) {
    if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
      return true;
    }
    return false;
  }

  public static void display(boolean[][] board) {
    for (boolean[] element : board) {
      for (boolean ans : element) {
        if (ans) {
          System.out.print("K ");
        } else {
          System.out.print("X ");
        }
      }
      System.out.println();
    }
  }
}