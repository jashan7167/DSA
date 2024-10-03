import java.util.*;

class Graph {
  List<List<Integer>> adj = new ArrayList<>();
  int V;

  Graph(int V) {
    for (int i = 0; i < V; i++) {
      List<Integer> ls = new ArrayList<>();
      adj.add(ls);
    }
  }

  public void addEdge(int u, int v) {
    adj.get(u).add(v);
    adj.get(v).add(u);
  }

  public void DFS(int node, int[] vis) {
    System.out.println(node);
    vis[node] = 1;
    for (Integer it : adj.get(node)) {
      if (vis[it] == 0) {
        DFS(it, vis);
      }
    }
  }

  public static void main(String[] args) {
    Graph g = new Graph(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    int[] vis = new int[4];
    Arrays.fill(vis, 0);

    System.out.println("DFS");
    g.DFS(0, vis);
  }
}
