import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'equalizeArray' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static int equalizeArray(List<Integer> arr) {
    int max_occurrences = 0;
    for (int i = 0; i < arr.size(); i++) {
      int occurrences = 0;
      for (int j = 0; j < arr.size(); j++) {
        if (arr.get(i).equals(arr.get(j))) // Compare using .equals() for objects
          occurrences++;
      }
      max_occurrences = Math.max(max_occurrences, occurrences);
    }
    return arr.size() - max_occurrences;
  }
}

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int result = Result.equalizeArray(arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
