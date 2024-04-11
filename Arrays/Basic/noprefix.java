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
   * Complete the 'noPrefix' function below.
   *
   * The function accepts STRING_ARRAY words as parameter.
   */

  public static void noPrefix(List<String> words) {
    boolean isBAD = false;
    for(int i = 0 ; i < words.size() ; i++)
    {
        int l = words.get(i).length();
        for(int j = i+1 ; j < words.size() ; j++)
        {
          if(l<words.get(j).length())
          {
            continue;
          }
          else
          {
            String sub = words.get(j).substring(0,l);
            if(words.get(i).equals(sub))
            {
                isBAD = true;
                break;
            }
          }
        }
    }

    }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<String> words = IntStream.range(0, n).mapToObj(i -> {
      try {
        return bufferedReader.readLine();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    })
        .collect(toList());

    Result.noPrefix(words);

    bufferedReader.close();
  }
}
