import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'rotateLeft' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   * 1. INTEGER d
   * 2. INTEGER_ARRAY arr
   */

  public static List<Integer> rotateLeft(int d, List<Integer> arr) {
    // Creating temp list
    List<Integer> temp = new ArrayList<>(arr.subList(0, d));

    // Moving the rest elements
    for (int i = d; i < arr.size(); i++) {
      arr.set(i - d, arr.get(i));
    }

    // Copying the temp list elements to the end
    for (int i = 0; i < d; i++) {
      arr.set(i + arr.size() - d, temp.get(i));
    }
    return arr;
  }

}

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int d = Integer.parseInt(firstMultipleInput[1]);

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    List<Integer> result = Result.rotateLeft(d, arr);

    bufferedWriter.write(
        result.stream()
            .map(Object::toString)
            .collect(joining(" "))
            + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
