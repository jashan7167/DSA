
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[][] edge = new int[m][3];
      for (int i = 0; i < m; i++) {
        edge[i][0] = sc.nextInt();
        edge[i][1] = sc.nextInt();
        edge[i][2] = sc.nextInt();
      }
      Solution obj = new Solution();
      int res[] = obj.shortestPath(n, m, edge);
      for (int i = 0; i < n; i++) {
        System.out.print(res[i] + " ");
      }
      System.out.println();
    }
  }
}
// } Driver Code Ends

// User function Template for Java
class Solution {

  class Pair {
    int first;
    int second;

    Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }

  public void toposort(int i, ArrayList<ArrayList<Pair>> adj, int[] vis, Stack<Integer> st) {
    vis[i] = 1;

    for (Pair it : adj.get(i)) {
      int v = it.first;
      if (vis[v] == 0) {
        toposort(v, adj, vis, st);
      }
    }

    st.add(i);

  }

  public int[] shortestPath(int N, int M, int[][] edges) {
    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    // creating adjacency list
    for (int i = 0; i < N; i++) {
      adj.add(new ArrayList<Pair>());
    }
    // populating adjacency list

    for (int i = 0; i < M; i++) {
      int u = edges[i][0];
      int v = edges[i][1];
      int wt = edges[i][2];
      adj.get(u).add(new Pair(v, wt));
    }
    int[] vis = new int[N];
    //O(N+M)
    Stack<Integer> st = new Stack<Integer>();
    for (int i = 0; i < N; i++) {
      if (vis[i] == 0) {
        toposort(i, adj, vis, st);
      }
    }

    int[] dis = new int[N];
    for (int i = 0; i < N; i++) {
      dis[i] = (int) 1e9;

    }
    dis[0] = 0;
    //O(N + M)
    while (!st.isEmpty()) {
      int node = st.peek();
      st.pop();

      for (Pair it : adj.get(node)) {
        int v = it.first;
        int wt = it.second;

        if (dis[node] + wt < dis[v]) {
          dis[v] = dis[node] + wt;
        }
      }
    }

    for (int i = 0; i < N; i++) {
      if (dis[i] == 1e9) {
        dis[i] = -1;
      }
    }

    return dis;

  }
}