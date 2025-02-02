import java.util.*;

class Solution {
  class Pair {
    int first;
    int second;

    Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }

  public int countPaths(int n, int[][] roads) {
    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<Pair>());
    }
    int m = roads.length;

    for (int i = 0; i < m; i++) {
      adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
      adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
    }

    PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.second - y.second);
    long[] dist = new long[n]; // Changed to long to avoid overflow
    int[] ways = new int[n];
    Arrays.fill(dist, Long.MAX_VALUE); // Changed to Long.MAX_VALUE
    Arrays.fill(ways, 0);
    dist[0] = 0;
    ways[0] = 1;
    pq.add(new Pair(0, 0));
    int mod = (int) (1e9 + 7);

    while (!pq.isEmpty()) {
      Pair it = pq.poll();
      int node = it.first;
      long distance = it.second; // Changed to long

      for (Pair iter : adj.get(node)) {
        int adjNode = iter.first;
        int edW = iter.second;

        if (distance + edW < dist[adjNode]) {
          dist[adjNode] = distance + edW;
          pq.add(new Pair(adjNode, (int) (distance + edW))); // Cast to int safely
          ways[adjNode] = ways[node];
        } else if (distance + edW == dist[adjNode]) {
          ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
        }
      }
    }

    return ways[n - 1] % mod;
  }
}
