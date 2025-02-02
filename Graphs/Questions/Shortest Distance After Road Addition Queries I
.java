class Solution {
    //add edges and run bfs as simple as that O(v+e) which obviously increases each time we run it as edges are increasing
    
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        //create a adjacency list to make a graph
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++)
        {
            adj.add(new ArrayList<>());
            // 0 - > 1 , 1 - > 2 , 2 - > 3 , 3-> 4
            adj.get(i).add(i+1);
        }
        List<Integer> res = new ArrayList<>();
        for(int[]query : queries)
        {
            int source = query[0];
            int target = query[1];
            adj.get(source).add(target);
            res.add(shortestPath(adj,n));
        }
        return res.stream().mapToInt(Integer::intValue).toArray();

    }
    private int shortestPath(List<List<Integer>> adj,int n)
    {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        Set<Integer> visit = new HashSet<>();
        visit.add(0);

        while(!q.isEmpty())
        {
            int[]curr = q.poll();
            int cur = curr[0];
            int length = curr[1];
            if(cur == n-1) return length;

            for(int nei : adj.get(cur))
            {
                if(!visit.contains(nei))
                {
                    q.offer(new int[]{nei,length + 1});
                    visit.add(nei);
                }
            }
        }
        return -1;
    }
}    

