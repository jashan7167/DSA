//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = Integer.parseInt(sc.next());
    while (t-- > 0) {
      int n = Integer.parseInt(sc.next());
      int k = Integer.parseInt(sc.next());

      String[] words = new String[n];

      for (int i = 0; i < n; i++) {
        words[i] = sc.next();
      }

      Solution ob = new Solution();
      // System.out.println(T.findOrder(words,k));
      String order = ob.findOrder(words, n, k);
      if (order.length() == 0) {
        System.out.println(0);
        continue;
      }
      if (order.length() != k) {
        System.out.println("INCOMPLETE");
        return;
      }
      String temp[] = new String[n];
      for (int i = 0; i < n; i++)
        temp[i] = words[i];

      Arrays.sort(temp, new Comparator<String>() {

        @Override
        public int compare(String a, String b) {
          int index1 = 0;
          int index2 = 0;
          for (int i = 0; i < Math.min(a.length(), b.length())
              && index1 == index2; i++) {
            index1 = order.indexOf(a.charAt(i));
            index2 = order.indexOf(b.charAt(i));
          }

          if (index1 == index2 && a.length() != b.length()) {
            if (a.length() < b.length())
              return -1;
            else
              return 1;
          }

          if (index1 < index2)
            return -1;
          else
            return 1;

        }
      });

      int flag = 1;
      for (int i = 0; i < n; i++) {
        if (!words[i].equals(temp[i])) {
          flag = 0;
          break;
        }
      }

      System.out.println(flag);
    }
  }

}

// } Driver Code Ends

// User function Template for Java

class Solution {
  public String findOrder(String[] dict, int N, int K) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    for (int i = 0; i < K; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < N - 1; i++) {
      String s1 = dict[i];
      String s2 = dict[i + 1];
      for (int ptr = 0; ptr < Math.min(s1.length(), s2.length()); ptr++) {
        if (s1.charAt(ptr) != s2.charAt(ptr)) {
          adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
          break;
        }
      }
    }
    int[] topo = new int[K];

    topo = topoSort(K, adj);
    String ans = "";
    for (int i = 0; i < topo.length; i++) {
      ans += (char) (topo[i] + (int) ('a'));
    }

    return ans;
  }

  static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
    int indegree[] = new int[V];
    int topo[] = new int[V];

    for (int i = 0; i < V; i++) {
      for (int it : adj.get(i)) {
        indegree[it]++;
      }
    }

    Queue<Integer> q = new LinkedList<Integer>();

    // add the nodes with 0 indegree it means that no matter what these nodes have
    // directed edge to others and will be placed before them

    for (int i = 0; i < V; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }
    int i = 0;
    while (!q.isEmpty()) {
      // pop the element and reduce the degree of the nodes it directs to when the
      // degree become zero it means we have remove all the nodes that has to be
      // before it and now its their turn
      int node = q.peek();
      q.remove();
      topo[i++] = node;

      for (int it : adj.get(node)) {
        indegree[it]--;
        if (indegree[it] == 0) {
          q.add(it);
        }
      }
    }

    return topo;

  }
}