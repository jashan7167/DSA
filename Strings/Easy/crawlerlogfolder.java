class Solution {
  public int minOperations(String[] logs) {
    int folder = 0;

    for (int i = 0; i < logs.length; i++) {
      if (logs[i].equals("../")) {
        folder--;
        if (folder < 0) {
          folder = 0;
        }
      } else if (logs[i].equals("./")) {
        continue;
      } else {
        folder++;
      }
    }

    return folder;

  }
}