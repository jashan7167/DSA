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
   * Complete the 'sorting' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static List<Integer> sorting(List<Integer> arr) {
    if(arr.size()==1)
    {
      return arr;
    }
    int mid = arr.size()/2;

    List<Integer> left = arr.subList(0, mid);
    List<Integer> right = arr.subList(mid,arr.size()-1);

    return merge(left,right);
    
    }
  public static List<Integer> merge(List<Integer>left, List<Integer> right)
  {
    int i = 0;
    int j = 0;
    List<Integer> combined = new ArrayList<Integer>();
    while(i<left.size() || j < right.size())
    {
       if(left.get(i)<right.get(j))
       {
        combined.add(left.get(i));
        i++;
       }
       else
       {
        combined.add(right.get(j));
        j++;
       }
    }
    if(i<left.size())
    {
      for(;i<left.size();i++)
      {
        combined.add(left.get(i));
      }
    }
    if(j<right.size())
    {
      for(; j<right.size();j++)
      {
        combined.add(right.get(j));
      }
    }

    return combined;

  }
}

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int size = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arrunsorted = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    List<Integer> result = Result.sorting(arrunsorted);

    bufferedWriter.write(
        result.stream()
            .map(Object::toString)
            .collect(joining(" "))
            + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
