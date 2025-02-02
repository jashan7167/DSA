import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'dynamicArray' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   * 1. INTEGER n
   * 2. 2D_INTEGER_ARRAY queries
   */

  public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    List<Integer> result = new ArrayList<>();
    List<List<Integer>> seqList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      seqList.add(new ArrayList<>());
    }

    int lastAns = 0;
    for (List<Integer> query : queries) {
      int type = query.get(0);
      int x = query.get(1);
      int y = query.get(2);
      int index = (x ^ lastAns) % n;

      if (type == 1) {
        seqList.get(index).add(y);
      } else if (type == 2) {
        List<Integer> seq = seqList.get(index);
        lastAns = seq.get(y % seq.size());
        result.add(lastAns);
      }
    }

    return result;
  }

class Solution {
  public void main(String[] args) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int q = Integer.parseInt(firstMultipleInput[1]);

    List<List<Integer>> queries = new ArrayList<>();

    IntStream.range(0, q).forEach(i -> {
      try {
        queries.add(
            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList()));
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    List<Integer> result = Result.dynamicArray(n, queries);

    bufferedWriter.write(
        result.stream()
            .map(Object::toString)
            .collect(joining("\n"))
            + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
}