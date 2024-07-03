class Solution {
  class Pair {
    String first;
    int second;

    Pair(String first, int second) {
      this.first = first;
      this.second = second;
    }
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(beginWord, 1));
    Set<String> st = new HashSet<String>();
    for (int i = 0; i < wordList.size(); i++) {
      st.add(wordList.get(i));
    }
    st.remove(beginWord);

    while (!q.isEmpty()) {
      String first = q.peek().first;
      int second = q.peek().second;
      q.remove();

      if (first.equals(endWord) == true) {
        return second;
      }

      for (int i = 0; i < first.length(); i++) {
        for (char ch = 'a'; ch <= 'z'; ch++) {
          char[] replacedCharArray = first.toCharArray();
          replacedCharArray[i] = ch;
          String replacedWord = new String(replacedCharArray);

          if (st.contains(replacedWord)) {
            st.remove(replacedWord);
            q.add(new Pair(replacedWord, second + 1));
          }

        }
      }

    }
    return 0;

  }
}