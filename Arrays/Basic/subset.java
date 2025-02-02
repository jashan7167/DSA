import java.util.*;

class subset {

  public static void main(String[] args) {
    int[] arr = { 1,2,2 };
    // System.out.println(subsets(arr));
    System.out.println(dusubsets(arr));

  }
  // basically what it does it create a list of lists and then add an empty list
  // to it create a copy of the original size of the outerlist add the one no
  // rejecting all other now we accept the other no with combination of previous
  // rejecting others now creating internal lists = outer.size and getting it
  // using outer.get(i) and appending our new no to create combinations

  // Time Complexity = O(N*2^N)
  // Space Complexity O(2^N * N)
  static List<List<Integer>> subsets(int[] arr) {
    List<List<Integer>> outer = new ArrayList<>();

    outer.add(new ArrayList<>());

    for (int num : arr) {

      int n = outer.size();
      for (int i = 0; i < n; i++) {
        List<Integer> internal = new ArrayList<>(outer.get(i));
        internal.add(num);
        outer.add(internal);
      }
    }
    return outer;
  }

  // when there are duplicate elements add the next duplicate element to the newly
  // created lists in the previous step as the duplicate element was already added
  // to the list before them
  // before to them
  //for this array needs to be sorted otherwise we cant figure out where is the next duplicate element
  static List<List<Integer>> dusubsets(int[] arr) {
    List<List<Integer>> outer = new ArrayList<>();

    outer.add(new ArrayList<>());
    Boolean flag = false;
    int prev = -1;
    for (int num : arr) {
      
      if(prev==num)
      {
        flag = true;
      }
      
      System.out.println(flag);
      
      int n = outer.size();
      if(flag==true)
      {
        for (int i = n/2; i < n; i++) {
          List<Integer> internal = new ArrayList<>(outer.get(i));
          internal.add(num);
          outer.add(internal);
        }
      }
      else
      {
        
        for (int i = 0; i < n; i++) {
          List<Integer> internal = new ArrayList<>(outer.get(i));
          internal.add(num);
          outer.add(internal);
        }
      }
      flag = false;
      prev = num;
    }
    
    return outer;
  }
}