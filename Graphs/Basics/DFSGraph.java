
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
      ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
      for (int i = 0; i < V; i++)
        adj.add(new ArrayList<Integer>());
      for (int i = 0; i < E; i++) {
        String[] S = br.readLine().trim().split(" ");
        int u = Integer.parseInt(S[0]);
        int v = Integer.parseInt(S[1]);
        adj.get(u).add(v);
        adj.get(v).add(u);
      }
      Solution obj = new Solution();
      ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
      for (int i = 0; i < ans.size(); i++)
        System.out.print(ans.get(i) + " ");
      System.out.println();
    }
  }
}

// } Driver Code Ends

class Solution {
  // Function to return a list containing the DFS traversal of the graph.
  public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean vis[] = new boolean[V + 1];
    // starting node is 0
    vis[0] = true;
    // store the dfs traversal in this
    ArrayList<Integer> ls = new ArrayList<>();
    dfs(0, vis, adj, ls);
    //

    return ls;
  }

  public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls) {

    // mark current node as visited
    vis[node] = true;
    // add node in dfs list
    ls.add(node);

    // get the neighbouring of each node
    for (Integer it : adj.get(node)) {
      // go to the node if its not visited earlier
      if (vis[it] == false) {
        dfs(it, vis, adj, ls);
      }
    }
  }
}