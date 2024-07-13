/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Tuple {
  TreeNode node;
  int row;
  int col;

  public Tuple(TreeNode node, int row, int col) {
    this.node = node;
    this.row = row;
    this.col = col;
  }
}

class Solution {
  public List<List<Integer>> verticalTraversal(TreeNode root) {

    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
    Queue<Tuple> q = new LinkedList<Tuple>();
    q.offer(new Tuple(root, 0, 0));
    while (!q.isEmpty()) {
      Tuple tuple = q.poll();
      TreeNode node = tuple.node;
      int vertical = tuple.row;
      int level = tuple.col;

      if (!map.containsKey(vertical)) {
        map.put(vertical, new TreeMap<>());
      }
      if (!map.get(vertical).containsKey(level)) {
        map.get(vertical).put(level, new PriorityQueue<>());
      }
      map.get(vertical).get(level).offer(node.val);

      if (node.left != null) {
        q.offer(new Tuple(node.left, vertical - 1, level + 1));
      }
      if (node.right != null) {
        q.offer(new Tuple(node.right, vertical + 1, level + 1));
      }
    }

    // basically for -1 -> there can be many levels
    // we have to start from the bottom
    // and take value at the -1 vertical at the last level to top most and pop it

    List<List<Integer>> list = new ArrayList<>();
    for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
      list.add(new ArrayList<>());
      for (PriorityQueue<Integer> nodes : ys.values()) {
        while (!nodes.isEmpty()) {
          list.get(list.size() - 1).add(nodes.poll());
        }
      }
    }

    return list;

  }
}