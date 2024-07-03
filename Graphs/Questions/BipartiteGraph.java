class Solution {
  public boolean dfs(int node, int col, int[] color, int[][] graph) {
    color[node] = col;
    // check the adjacent node
    for (int adj : graph[node]) {
      if (color[adj] == -1) {
        if (dfs(adj, 1 - col, color, graph) == false) {
          return false;
        }
      }

      if (color[adj] == col) {
        return false;
      }
    }

    return true;
  }

  public boolean isBipartite(int[][] graph) {
    int n = graph.length;
    int[] color = new int[n + 1];
    Arrays.fill(color, -1);

    for (int i = 0; i < n; i++) {
      if (color[i] == -1) {
        if (dfs(i, 0, color, graph) == false)
          return false;
      }
    }
    return true;

  }
}