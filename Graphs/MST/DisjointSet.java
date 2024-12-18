import java.io.*;
import java.util.*;

public class DisjointSet {
  List<Integer> rank = new ArrayList<>();
  List<Integer> parent = new ArrayList<>();
  List<Integer> size = new ArrayList<>();

  public DisjointSet(int n) {
    for (int i = 0; i <= n; i++) {
      rank.add(0);
      parent.add(i);
      size.add(1);
    }
  }

  public int findUPar(int node) {
    if (node == parent.get(node)) {
      return node;
    }
    int ult = findUPar(parent.get(node));
    parent.set(node, ult);
    return parent.get(node);
  }

  public void unionByRank(int u, int v) {
    int ulp_u = findUPar(u);
    int ulp_v = findUPar(v);
    if (ulp_u == ulp_v) {
      return;
    }
    if (rank.get(ulp_u) < rank.get(ulp_v)) {
      parent.set(ulp_u, ulp_v);
    } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
      parent.set(ulp_v, ulp_u);
    } else {
      parent.set(ulp_v, ulp_u);
      int rankU = rank.get(ulp_u);
      rank.set(ulp_u, rankU + 1);
    }

  }

  public void unionBySize(int u, int v) {
    int ulp_u = findUPar(u);
    int ulp_v = findUPar(v);
    if (ulp_u == ulp_v) {
      return;
    }
    // size of u is smaller than v set u to v and increase size of v
    if (size.get(ulp_u) < size.get(ulp_v)) {
      parent.set(ulp_u, ulp_v);
      size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
    } else {
      parent.set(ulp_v, ulp_u);
      size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
    }

  }

}

class Main {

  public static void main(String[] args) {
    DisjointSet set = new DisjointSet(7);
    set.unionByRank(1, 2);
    set.unionByRank(2, 3);
    set.unionByRank(4, 5);
    set.unionByRank(6, 7);
    set.unionByRank(5, 6);
    set.unionBySize(1, 2);
    set.unionBySize(2, 3);
    set.unionBySize(4, 5);
    set.unionBySize(6, 7);
    set.unionBySize(5, 6);

    if (set.findUPar(3) == set.findUPar(7)) {
      System.out.println("same");
    } else {
      System.out.println("Not same");
    }

    // set.unionByRank(3, 7);
    set.unionBySize(3, 7);
    if (set.findUPar(3) == set.findUPar(7)) {
      System.out.println("same");
    } else {
      System.out.println("Not same");
    }

  }

}
