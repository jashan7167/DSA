class Pair {
  Node node;
  int line;

  Pair(Node node, int line) {
    this.node = node;
    this.line = line;
  }
}

class Solution {
  // Function to return a list containing the bottom view of the given tree.
  public ArrayList<Integer> bottomView(Node root) {
    ArrayList<Integer> ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }
    Queue<Pair> q = new LinkedList<>();
    Map<Integer, Integer> map = new TreeMap<>();
    q.add(new Pair(root, 0));
    while (!q.isEmpty()) {
      Pair it = q.poll();
      Node node = it.node;
      int line = it.line;

      map.put(line, node.data);

      if (node.left != null) {
        q.add(new Pair(node.left, line - 1));
      }

      if (node.right != null) {
        q.add(new Pair(node.right, line + 1));
      }

    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      ans.add(entry.getValue());
    }

    return ans;

  }
}