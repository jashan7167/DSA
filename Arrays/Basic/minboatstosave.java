import java.util.Arrays;
class Solution {
  public int numRescueBoats(int[] people, int limit) {
    int left = 0;
    int count = 0;
    int right = people.length - 1;
    Arrays.sort(people);
    while (left <= right) {
      int weight = people[left] + people[right];
      if (weight <= limit) {
        // take both lightest and heavy paired
        left++;
        right--;
      } else {
        // leave the light one as it can be paired with another one so take the heavy
        // one to minimise the boats
        right--;
      }
      count++;
    }

    return count;

  }
}