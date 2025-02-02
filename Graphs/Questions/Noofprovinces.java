class Solution {
  private int count = 0;

  public int findCircleNum(int[][] isConnected) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    int V = isConnected.length;

    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<Integer>());
    }

    // to change adjacency matrix to list
    for (int i = 0; i < V; i++) {
      for (int j = 0; j < V; j++) {
        if (i != j && isConnected[i][j] == 1) {
          adj.get(i).add(j);
          adj.get(j).add(i);
        }
      }
    }

    int[] vis = new int[V + 1];
    int cnt = 0;
    for (int i = 0; i < V; i++) {
      if (vis[i] == 0) {
        dfs(i, adj, vis);
        cnt++;
      }
    }

    return cnt;

  }

  public void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis) {
    vis[node] = 1;

    for (Integer it : adj.get(node)) {
      if (vis[it] == 0) {
        dfs(it, adj, vis);
      }
    }
  }
}