import java.util.Stack;

public class Gameoftwostacks {
  public static int getMax(Stack<Integer> st1, Stack<Integer> st2, int maxSum, int sum, int count) {
    if (sum > maxSum) {
      return count;
    }
    if(st1.isEmpty() || st2.isEmpty())
    {
      return count;
    }
    int ans1 = 0;
    int ans2 = 0;
    if(!st1.isEmpty())
    {
      int top1 = st1.pop();
      ans1 = getMax(st1, st2, maxSum, sum + top1,count+1);
      st1.push(top1);
    }
    if(!st2.isEmpty())
    {
      int top2 = st2.pop();
      ans2 =  getMax(st1, st2, maxSum, sum + top2, count + 1);
      st2.push(top2);
    }
    return Math.max(ans1,ans2);
  }

  public static void main(String[] args) {
    int[] arr1 = { 5, 4, 3, 2, 1 };
    int[] arr2 = { 9, 8, 7, 6 };
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();

    for (int i = 0; i < arr1.length; i++) {
      st1.push(arr1[i]);
    }
    for (int i = 0; i < arr2.length; i++) {
      st2.push(arr2[i]);
    }

    System.out.println(getMax(st1, st2, 10, 0, 0)-1);
  }
}
