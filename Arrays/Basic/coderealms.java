import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'decipher_power' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER n as parameter.
   */

  public static int decipher_power(int n) {
    int r = 1;
    int s = 1;
    double pow;
    do {
      pow = Math.pow(2, r);
      if (pow == n) {
        return 2;
      }
      r++;
    } while (pow < n);
    do {
      pow = Math.pow(3, s);
      if (pow == n) {
        return 3;
      }
      s++;
    } while (pow < n);

    return -1;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    int result = Result.decipher_power(n);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
