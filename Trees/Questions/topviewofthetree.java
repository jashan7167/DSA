import java.util.*;

class Pair {
  Node node;
  int line;

  Pair(Node node, int line) {
    this.node = node;
    this.line = line;
  }

}

class Solution {
  static ArrayList<Integer> topView(Node root) {
    ArrayList<Integer> ans = new ArrayList<Integer>();
    if (root == null) {
      return ans;
    }
    Map<Integer, Integer> map = new TreeMap<>();
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(root, 0));

    while (!q.isEmpty()) {
      Pair it = q.poll();
      Node node = it.node;
      int line = it.line;

      // if no node associated with this line exists in the map then add it into the
      // map
      if (map.get(line) == null) {
        map.put(line, node.data);
      }

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