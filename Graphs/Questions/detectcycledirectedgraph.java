
//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      ArrayList<ArrayList<Integer>> list = new ArrayList<>();
      int V = sc.nextInt();
      int E = sc.nextInt();
      for (int i = 0; i < V; i++)
        list.add(i, new ArrayList<Integer>());
      for (int i = 0; i < E; i++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        list.get(u).add(v);
      }
      if (new Solution().isCyclic(V, list) == true)
        System.out.println("1");
      else
        System.out.println("0");
    }
  }
}
// } Driver Code Ends

/* Complete the function below */

class Solution {
  public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] pathVis, int[] vis) {
    pathVis[node] = 1;
    vis[node] = 1;

    for (int it : adj.get(node)) {
      if (vis[it] == 0) {
        if (dfs(it, adj, pathVis, vis) == true) {
          return true;
        }
      }
      // if the node is visited and also visited on the same path then there is a
      // cycle
      else if (pathVis[it] == 1) {
        return true;
      }
    }
    // backtrack on the path and make the pathVis[node] = 0;
    pathVis[node] = 0;
    return false;
  }

  // Function to detect cycle in a directed graph.
  public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
    // code here
    int[] pathVis = new int[V];
    int[] vis = new int[V];

    for (int i = 0; i < V; i++) {
      if (vis[i] == 0) {
        if (dfs(i, adj, pathVis, vis) == true) {
          return true;
        }
      }
    }

    return false;

  }
}