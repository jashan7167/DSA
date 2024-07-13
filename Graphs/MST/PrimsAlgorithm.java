//{ Driver Code Starts

import java.io.*;
import java.lang.*;
import java.util.*;

public class PrimsAlgorithm {
  static BufferedReader br;
  static PrintWriter ot;

  public static void main(String args[]) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    ot = new PrintWriter(System.out);
    int t = Integer.parseInt(br.readLine().trim());
    while (t-- > 0) {
      String s[] = br.readLine().trim().split(" ");
      int V = Integer.parseInt(s[0]);
      int E = Integer.parseInt(s[1]);
      List<List<int[]>> list = new ArrayList<>();
      for (int i = 0; i < V; i++)
        list.add(new ArrayList<>());
      for (int i = 0; i < E; i++) {
        s = br.readLine().trim().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);
        list.get(a).add(new int[] { b, c });
        list.get(b).add(new int[] { a, c });
      }
      ot.println(new Solution().spanningTree(V, E, list));
    }
    ot.close();
  }
}
// } Driver Code Ends

// User function Template for Java
class Pair {
  int distance;
  int node;

  Pair(int distance, int node) {
    this.distance = distance;
    this.node = node;
  }
}

class Solution {
  static int spanningTree(int V, int E, List<List<int[]>> adj) {
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

    int[] vis = new int[V];

    pq.add(new Pair(0, 0));
    int sum = 0;
    while (!pq.isEmpty()) {
      Pair it = pq.poll();
      int wt = it.distance;
      int node = it.node;

      if (vis[node] == 1)
        continue;

      vis[node] = 1;
      sum += wt;

      for (int i = 0; i < adj.get(node).size(); i++) {
        int edW = adj.get(node).get(i)[1];
        int adjNode = adj.get(node).get(i)[0];

        if (vis[adjNode] == 0) {
          pq.add(new Pair(edW, adjNode));
        }
      }

    }

    return sum;
  }
}