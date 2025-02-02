import java.util.*;

class DisjointSet {
  List<Integer> rank = new ArrayList<>();
  List<Integer> parent = new ArrayList<>();
  List<Integer> size = new ArrayList<>();

  public DisjointSet(int n) {
    for (int i = 0; i <= n; i++) {
      rank.add(0);
      parent.add(i);
      size.add(1);
    }
  }

  public int findUPar(int node) {
    if (node == parent.get(node)) {
      return node;
    }
    int ult = findUPar(parent.get(node));
    parent.set(node, ult);
    return parent.get(node);
  }

  public void unionByRank(int u, int v) {
    int ulp_u = findUPar(u);
    int ulp_v = findUPar(v);
    if (ulp_u == ulp_v) {
      return;
    }
    if (rank.get(ulp_u) < rank.get(ulp_v)) {
      parent.set(ulp_u, ulp_v);
    } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
      parent.set(ulp_v, ulp_u);
    } else {
      parent.set(ulp_v, ulp_u);
      int rankU = rank.get(ulp_u);
      rank.set(ulp_u, rankU + 1);
    }

  }

  public void unionBySize(int u, int v) {
    int ulp_u = findUPar(u);
    int ulp_v = findUPar(v);
    if (ulp_u == ulp_v) {
      return;
    }
    // size of u is smaller than v set u to v and increase size of v
    if (size.get(ulp_u) < size.get(ulp_v)) {
      parent.set(ulp_u, ulp_v);
      size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
    } else {
      parent.set(ulp_v, ulp_u);
      size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
    }

  }

}

class Solution {
  public boolean isValid(int adjr, int adjc, int n) {
    return adjr >= 0 && adjr < n && adjc >= 0 && adjc < n;
  }

  public int largestIsland(int[][] grid) {
    int n = grid.length;
    DisjointSet ds = new DisjointSet(n * n);

    for (int row = 0; row < n; row++) {
      for (int col = 0; col < n; col++) {
        if (grid[row][col] == 0) {
          continue;
        }

        int[] dr = { -1, 0, +1, 0 };
        int[] dc = { 0, -1, 0, +1 };
        for (int idx = 0; idx < 4; idx++) {
          int adjr = row + dr[idx];
          int adjc = col + dc[idx];
          if (isValid(adjr, adjc, n) && grid[adjr][adjc] == 1) {
            int node = row * n + col;
            int adjNode = adjr * n + adjc;
            ds.unionBySize(node, adjNode);

          }
        }
      }
    }
    int mx = 0;

    for (int row = 0; row < n; row++) {
      for (int col = 0; col < n; col++) {
        if (grid[row][col] == 1) {
          continue;
        }
        HashSet<Integer> components = new HashSet<>();
        int[] dr = { -1, 0, +1, 0 };
        int[] dc = { 0, -1, 0, +1 };
        for (int idx = 0; idx < 4; idx++) {
          int adjr = row + dr[idx];
          int adjc = col + dc[idx];
          if (isValid(adjr, adjc, n) && grid[adjr][adjc] == 1) {
            components.add(ds.findUPar(adjr * n + adjc));

          }
        }

        int sizeTotal = 0;
        for (Integer parents : components) {
          sizeTotal += ds.size.get(parents);
        }

        mx = Math.max(mx, sizeTotal + 1);
      }
    }
    for (int cellNo = 0; cellNo < n * n; cellNo++) {
      mx = Math.max(mx, ds.size.get(ds.findUPar(cellNo)));
    }

    return mx;

  }
}