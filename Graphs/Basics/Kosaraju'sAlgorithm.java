//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());

            for (int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());

            for (int i = 1; i <= E; i++) {
                int u = Integer.parseInt(sc.next());
                int v = Integer.parseInt(sc.next());

                // adding directed edgese between
                // vertex 'u' and 'v'
                adj.get(u).add(v);
            }

            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    public void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, LinkedList<Integer> st) {
        vis[node] = 1;
        for (Integer it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(it, vis, adj, st);
            }
        }

        st.add(node);
    }

    public void dfs2(int node, int[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for (Integer it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs2(it, vis, adj);
            }
        }
    }

    // Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        LinkedList<Integer> st = new LinkedList<Integer>();
        for (int i = 0; i < V; i++) {
            // doing dfs before reversing the edges to find out the nodes in the strongly
            // connected component
            if (vis[i] == 0) {
                dfs(i, vis, adj, st);
            }
        }

        ArrayList<ArrayList<Integer>> adjT = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < V; i++) {
            // reset the visited array
            vis[i] = 0;
            for (Integer it : adj.get(i)) {
                adjT.get(it).add(i);
            }
        }

        int scc = 0;
        while (st.size() != 0) {
            int node = st.removeLast();
            if (vis[node] == 0) {
                scc++;
                dfs2(node, vis, adjT);
            }
        }

        return scc;
    }
}
