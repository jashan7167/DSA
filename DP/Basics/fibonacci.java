import java.util.Arrays;
import java.util.Scanner;

class Fibonacci {
  public static int fibonacci(int n, int[] dp) {
    if (n <= 1) {
      return n;
    }

    if (dp[n] != -1) {
      return dp[n];
    }

    return dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);

  }

  public static void main(String[] args) {
    int n;
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    System.out.println(fibonacci(n, dp));

    // using other method to save more space
    // O(n) and O(n)
    // we will also be checking this pattern where we will be
    // checking prev and prev2 in all further questions

    int prev2 = 0;
    int prev = 1;

    for (int i = 2; i <= n; i++) {
      int curi = prev + prev2;
      prev2 = prev;
      prev = curi;
    }

    System.out.println(prev);
    sc.close();

  }
}