class Solution {
    class Pair {
        int distance;
        int node;
        
        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Pair>());
        }
        
        // Populate the adjacency list
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        
        // Adding the comparator such that we can compare the added elements using the distance
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        
        Arrays.fill(dist, (int) 1e9);
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        
        dist[1] = 0;
        pq.add(new Pair(1, 0));
        
        while (!pq.isEmpty()) {
            Pair it = pq.poll();
            int node = it.node;
            int distance = it.distance;
            
            for (Pair iter : adj.get(node)) {
                int adjNode = iter.node;
                int edgeWeight = iter.distance;
                
                if (distance + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = distance + edgeWeight;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                    parent[adjNode] = node;
                }
            }
        }
        
        List<Integer> ls = new ArrayList<>();
        // Check if there's a path to the last node
        if (dist[n] == (int) 1e9) {
            ls.add(-1);
            return ls;// No path found
        } else {
            ls.add(dist[n]); // Shortest path distance
        return ls;
        }
        
    }
}