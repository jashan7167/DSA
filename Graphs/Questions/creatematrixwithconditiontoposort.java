class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // first we need to create a rowGraph
        List<Integer>[] rowGraph = new ArrayList[k + 1];

        for (int i = 1; i < rowGraph.length; i++) {
            rowGraph[i] = new ArrayList();
        }

        for (int[] rowCondition : rowConditions) {
            rowGraph[rowCondition[0]].add(rowCondition[1]);
        }

        // create similaryColumn graph

        List<Integer>[] colGraph = new ArrayList[k + 1];

        for (int i = 1; i < colGraph.length; i++) {
            colGraph[i] = new ArrayList();
        }

        for (int[] colCondition : colConditions) {
            colGraph[colCondition[0]].add(colCondition[1]);
        }

        int[] visited = new int[k + 1];
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 1; i < rowGraph.length; i++) {
            if (!topoSort(rowGraph, i, visited, queue)) {
                // if we detect a cycle in the graph it is not possible to perfrom the toposort
                return new int[0][0];
            }
        }

        int[] rowIndexMap = new int[k + 1];
        for (int i = 0; i < k; i++) {
            // we are starting the last because at the end will the node that finished dfs
            // last and will be before all the other nodes
            int node = queue.pollLast();
            rowIndexMap[node] = i;
        }

        visited = new int[k + 1];
        queue = new LinkedList<>();

        for (int i = 1; i < colGraph.length; i++) {
            if (!topoSort(colGraph, i, visited, queue)) {
                // if we detect a cycle in the graph it is not possible to perfrom the toposort
                return new int[0][0];
            }
        }

        int[] colIndexMap = new int[k + 1];
        for (int i = 0; i < k; i++) {
            // we are starting the last because at the end will the node that finished dfs
            // last and will be before all the other nodes
            int node = queue.pollLast();
            colIndexMap[node] = i;
        }

        int[][] result = new int[k][k];

        for (int i = 1; i <= k; i++) {
            result[rowIndexMap[i]][colIndexMap[i]] = i;
        }
        return result;
    }

    public boolean topoSort(List<Integer>[] graph, int node, int[] visited, Deque<Integer> dq) {
        if (visited[node] == 2) {
            return false;
        }
        if (visited[node] == 0) {
            visited[node] = 2;
            for (int child : graph[node]) {
                if (!topoSort(graph, child, visited, dq)) {
                    return false;
                }
            }
            visited[node] = 1;
            dq.add(node);
        }

        return true;
    }
}