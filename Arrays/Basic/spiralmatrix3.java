class Solution {
  public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
    int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    List<int[]> result = new ArrayList<>();
    int r = rStart, c = cStart;
    int steps = 1;
    int val = 0;
    int direc = 0;
    while (result.size() < rows * cols) {
      for (int i = 0; i < 2; i++) {
        int dr = directions[direc][0];
        int dc = directions[direc][1];
        for (int j = 0; j < steps; j++) {
          if (r >= 0 && r < rows && c >= 0 && c < cols) {
            result.add(new int[] { r, c });
          }
          val++;
          r += dr;
          c += dc;
        }
        direc = (direc + 1) % 4;
      }
      steps++;
    }

    return result.toArray(new int[result.size()][]);

  }
}