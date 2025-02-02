
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    while (T-- > 0) {
      String[] s = br.readLine().trim().split(" ");
      int V = Integer.parseInt(s[0]);
      int E = Integer.parseInt(s[1]);
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      for (int i = 0; i < V; i++)
        adj.add(i, new ArrayList<Integer>());
      for (int i = 0; i < E; i++) {
        String[] S = br.readLine().trim().split(" ");
        int u = Integer.parseInt(S[0]);
        int v = Integer.parseInt(S[1]);
        adj.get(u).add(v);
        adj.get(v).add(u);
      }
      Solution obj = new Solution();
      boolean ans = obj.isCycle(V, adj);
      if (ans)
        System.out.println("1");
      else
        System.out.println("0");
    }
  }
}
// } Driver Code Ends

class Solution {
  class Pair {
    int src;
    int dest;

    Pair(int src, int dest) {
      this.src = src;
      this.dest = dest;
    }
  }

  public boolean checkforCycle(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
    vis[src] = true;
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(src, -1));
    while (!q.isEmpty()) {
      int node = q.peek().src;
      int parent = q.peek().dest;
      q.remove();

      for (int adja : adj.get(node)) {
        if (vis[adja] == false) {
          vis[adja] = true;
          q.add(new Pair(adja, node));
        } else if (vis[adja] == true && parent != adja) {
          return true;
        }
      }
    }

    return false;
  }

  // Function to detect cycle in an undirected graph.
  public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] vis = new boolean[V];
    Arrays.fill(vis, false);
    for (int i = 0; i < V; i++) {
      if (vis[i] == false) {
        if (checkforCycle(i, adj, vis)) {
          return true;
        }
      }
    }

    return false;
  }
}