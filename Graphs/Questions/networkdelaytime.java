class Solution {
  class Pair {
    int first;
    int second;

    Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }

  public int networkDelayTime(int[][] times, int n, int k) {
    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

    for (int i = 0; i <= n; i++) {
      adj.add(new ArrayList<Pair>());
    }

    for (int i = 0; i < times.length; i++) {
      adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
    }
    int[] dist = new int[n + 1];
    Arrays.fill(dist, (int) 1e9);
    dist[k] = 0;
    PriorityQueue<Pair> q = new PriorityQueue<>((x, y) -> x.second - y.second);
    q.add(new Pair(k, 0));
    while (!q.isEmpty()) {
      Pair it = q.poll();
      int node = it.first;
      int distance = it.second;

      for (Pair iter : adj.get(node)) {
        int adjNode = iter.first;
        int edgW = iter.second;

        if (distance + edgW < dist[adjNode]) {
          dist[adjNode] = distance + edgW;
          q.add(new Pair(adjNode, distance + edgW));
        }
      }
    }
    System.out.println(Arrays.toString(dist));

    int maxTime = 0;
    for (int i = 1; i <= n; i++) {
      if (dist[i] == (int) 1e9) {
        return -1;
      }
      maxTime = Math.max(maxTime, dist[i]);
    }

    return maxTime;

  }
}