class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adj = new ArrayList<>();
    // first we need to create a graph
    for (int i = 0; i < numCourses; i++) {
      adj.add(new ArrayList<>());
    }
    // populating the adjacency list
    for (int i = 0; i < prerequisites.length; i++) {
      adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
    }
    int[] indegree = new int[numCourses];

    for (int i = 0; i < numCourses; i++) {
      for (int it : adj.get(i)) {
        indegree[it]++;
      }
    }

    Queue<Integer> q = new LinkedList<Integer>();
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    int[] topo = new int[numCourses];
    int i = 0;
    while (!q.isEmpty()) {
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

    if (i == numCourses) {
      return topo;
    } else {
      return new int[] {};
    }
  }
}