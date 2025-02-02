
//{ Driver Code Starts
// Initial Template for Java
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
      ArrayList<Integer> ans = obj.articulationPoints(V, adj);
      for (int i = 0; i < ans.size(); i++)
        System.out.print(ans.get(i) + " ");
      System.out.println();
    }
  }
}

// } Driver Code Ends

class Solution {
  private int timer = 1;

  private void dfs(int node, int parent, int[] vis, int[] tin, int[] low, int[] mark,
      ArrayList<ArrayList<Integer>> adj) {
    // Mark the current node as visited
    vis[node] = 1;
    tin[node] = low[node] = timer++;
    int children = 0; // Count of children in the DFS tree

    for (Integer it : adj.get(node)) {
      if (it == parent)
        continue; // If the adjacent node is the parent, skip it

      if (vis[it] == 0) {
        dfs(it, node, vis, tin, low, mark, adj);
        low[node] = Math.min(low[node], low[it]);

        // If the lowest vertex reachable from subtree under it is below the node in the
        // DFS tree
        if (low[it] >= tin[node] && parent != -1) {
          mark[node] = 1;
        }
        children++;
      } else {
        // Update low value of node for parent function calls
        low[node] = Math.min(low[node], tin[it]);
      }
    }

    // If node is root of DFS tree and has more than one child
    if (parent == -1 && children > 1) {
      mark[node] = 1;
    }
  }

  public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
    int[] vis = new int[V];
    int[] tin = new int[V];
    int[] low = new int[V];
    int[] mark = new int[V];
    // doing this for connected components
    for (int i = 0; i < V; i++) {
      if (vis[i] == 0) {
        dfs(i, -1, vis, tin, low, mark, adj);
      }
    }

    ArrayList<Integer> ans = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      if (mark[i] == 1) {
        ans.add(i);

      }
    }

    if (ans.size() == 0) {
      ans.add(-1);
      return ans;
    }

    return ans;

  }
}