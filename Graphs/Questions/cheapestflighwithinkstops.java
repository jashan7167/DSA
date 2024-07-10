class Solution {
  class Pair {
    int first;
    int second;

    Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }

  class Tuple {
    int first;
    int second;
    int third;

    Tuple(int f, int s, int t) {
      this.first = f;
      this.second = s;
      this.third = t;
    }
  }

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<Pair>());
    }
    int edges = flights.length;

    for (int i = 0; i < edges; i++) {
      adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
    }

    Queue<Tuple> q = new LinkedList<>();

    q.add(new Tuple(0, src, 0));
    int[] dist = new int[n];
    for (int i = 0; i < n; i++) {
      dist[i] = (int) 1e9;
    }

    dist[src] = 0;
    // simple case is dont traverse on the paths with stops greater than k go to the
    // path less cost and less stops then less than equal to k thats it no big shit
    // happening here
    while (!q.isEmpty()) {
      Tuple it = q.poll();
      int stops = it.first;
      int node = it.second;
      int cost = it.third;

      if (stops > k)
        continue;
      for (Pair itr : adj.get(node)) {
        int adjNode = itr.first;
        int edW = itr.second;

        if (cost + edW < dist[adjNode]) {
          dist[adjNode] = cost + edW;
          q.add(new Tuple(stops + 1, adjNode, cost + edW));
        }
      }
    }

    if (dist[dst] == (int) (1e9)) {
      return -1;
    }

    return dist[dst];

  }
}