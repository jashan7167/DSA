class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        //create a adjacency list first
        ArrayList<Integer>[] graph = new ArrayList[amount.length];
        for(int i = 0 ; i < graph.length ; i++) graph[i] = new ArrayList<>();
        for(int[] edge : edges)
        {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[] bobPath = new int[amount.length];
        Arrays.fill(bobPath,-1);
        ArrayList<Integer> path = new ArrayList<>();
        fillBobPath(bob,-1,path,graph);

        //add the time stamps to the bob path
        for(int i = 0 ; i < path.size() ; i++)
        {
            bobPath[path.get(i)] = i;
        }

        return getAliceMaxScore(0,-1,0,bobPath,graph,0,amount);
        
    }

    private boolean fillBobPath(int node , int parentNode , ArrayList<Integer> path , ArrayList<Integer>[]graph)
    {
        //if we are already at the source node then return true
        if(node==0) return true;
        for(int neighbourNode : graph[node])
        {
            if(neighbourNode!=parentNode)
            {
                path.add(node);
                //this means the path has been found return true so it propogates 
                if(fillBobPath(neighbourNode,node,path,graph)) return true;
                //otherwise remove this node and go the other neighbour node
                path.remove(path.size()-1);
            }
        }
        return false;
    }

    private int getAliceMaxScore(int node , int parentNode , int currScore , int[] bobPath , ArrayList<Integer>[] graph , int timestamp , int[] amount )
    {
    // if bob has not visited the node or visited it later on we add on the current score
        if(bobPath[node]==-1 || bobPath[node] > timestamp)
        {
            currScore+=amount[node];
        }
    //if they reach on the same point then they share the profit
        else if(bobPath[node] == timestamp)
        {
            currScore += amount[node]/2;
        }
    //if we have reached the leafnode then return the currscore
        if(graph[node].size()==1 && node != 0) return currScore;
        int maxScore = Integer.MIN_VALUE;
        for(int neighborNode : graph[node])
     //go to the neighborNodes and find the best path and return the maxScore out of all of them
            if(neighborNode != parentNode)
            {
                maxScore = Math.max(maxScore , getAliceMaxScore(neighborNode,node,currScore,bobPath,graph,timestamp+1,amount));
            }
        }
    return maxScore;

    }
}
