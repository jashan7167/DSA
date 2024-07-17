//{ Driver Code Starts

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
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

class Edge implements Comparable<Edge> {
  int src, dest, wt;

  Edge(int src, int dest, int wt) {
    this.src = src;
    this.dest = dest;
    this.wt = wt;
  }

  public int compareTo(Edge compareEdge) {
    return this.wt - compareEdge.wt;
  }
};

class Solution {
  static int spanningTree(int V, int E, List<List<int[]>> adj) {
    List<Edge> edges = new ArrayList<Edge>();
    // [ [[1,2,[2,3]]]] //so basically for the 1st node there are two nodes 1 2 with
    // weights 2 and 3 thats why nested array list are there as we have to store the
    // weights also
    for (int i = 0; i < V; i++) {
      for (int j = 0; j < adj.get(i).size(); j++) {
        int adjNode = adj.get(i).get(j)[0];
        int wt = adj.get(i).get(j)[1];
        int node = i;
        Edge temp = new Edge(i, adjNode, wt);
        edges.add(temp);
      }
    }
    DisjointSet ds = new DisjointSet(V);
    Collections.sort(edges);
    int mstWt = 0;

    for (int i = 0; i < edges.size(); i++) {
      int wt = edges.get(i).wt;
      int u = edges.get(i).src;
      int v = edges.get(i).dest;

      if (ds.findUPar(u) != ds.findUPar(v)) {
        mstWt += wt;
        ds.unionBySize(u, v);
      }
    }

    return mstWt;

  }
}