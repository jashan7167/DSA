public class longestsubarraywithsumk {

  public static int longestSubarrayWithSumK(int[] a, long k) {
    int l = Integer.MIN_VALUE;
    int sum = 0;
    int isSubArray = 0;
    for (int i = 0; i < a.length; i++) {
      sum = 0;
      for (int j = i; j < a.length; j++) {
        sum += a[j];
        if (sum == k) {
          l = Math.max(l, j - i + 1);
          isSubArray = 1;
        }
      }
    }
    if (isSubArray == 0)
      return 0;
    else {
      return l;

    }

  }

  public static void main(String[] args) {
    System.out.println(longestSubarrayWithSumK(new int[] { 1, 2, 3, 1, 1, 1, 1 }, 3));

  }
}
