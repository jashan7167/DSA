class Solution {
    //using unordered map 
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer,List<Integer>> graph  = new HashMap<>();

        for(int[] edge: edges)
        {
            int u = edge[0], v = edge[1];

            if(graph.containsKey(u) && graph.containsKey(v) && isConnected(graph,u,v))
            {
                return edge;
            }

            graph.putIfAbsent(u,new ArrayList<>());
            graph.putIfAbsent(v,new ArrayList<>());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return new int[0];
    }

        public boolean isConnected(Map<Integer,List<Integer>> graph,int u,int v)
        {
            Set<Integer> visited = new HashSet<>();
            Stack<Integer> stack = new Stack<>();
            stack.push(u);
            
            while(!stack.isEmpty())
            {
                int node = stack.pop();
                if(!visited.add(node)) continue; //returns false when set cannot add a duplicate value
                if(node == v) return true;

                for(int neighbour : graph.getOrDefault(node,new ArrayList<>()))
                {
                    stack.push(neighbour);
                }
            }
            return false;
        }

    }

