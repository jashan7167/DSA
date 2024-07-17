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

class Solution {
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    int n = accounts.size();
    DisjointSet ds = new DisjointSet(n);
    HashMap<String, Integer> mapMailNode = new HashMap<String, Integer>();

    for (int i = 0; i < n; i++) {
      for (int j = 1; j < accounts.get(i).size(); j++) {
        String mail = accounts.get(i).get(j);
        // if you dont contain the mail you need to put the mail in the hashmap with the
        // node
        if (mapMailNode.containsKey(mail) == false) {
          mapMailNode.put(mail, i);
        }
        // if there is already the email associated with the node attach the current
        // node to the node which we get from the already there mail
        else {
          ds.unionBySize(i, mapMailNode.get(mail));
        }
      }
    }

    ArrayList<String>[] mergedMail = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      mergedMail[i] = new ArrayList<String>();
    }
    // iterate over the enteries of the hashmap
    for (Map.Entry<String, Integer> it : mapMailNode.entrySet()) {
      // get the node for which the mail is attached to
      String mail = it.getKey();
      // get the parent of the mail and then add it to the list
      int node = ds.findUPar(it.getValue());
      mergedMail[node].add(mail);
    }

    List<List<String>> ans = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      if (mergedMail[i].size() == 0)
        continue;
      Collections.sort(mergedMail[i]);
      List<String> temp = new ArrayList<>();
      // replace the node values with the name of the account
      temp.add(accounts.get(i).get(0));
      for (String it : mergedMail[i]) {
        temp.add(it);
      }
      ans.add(temp);
    }

    return ans;

  }
}