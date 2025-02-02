import java.util.Stack;
import java.util.Arrays;

public class rightsmallerelement {
  public static int[] nextsmallerelement(int[] arr) {
    Stack<Integer> st = new Stack<Integer>();
    int[] out = new int[arr.length];
    Arrays.fill(out, -1);

    for (int i = arr.length - 1; i >= 0; i--) {
      while (!st.isEmpty() && st.peek() >= arr[i]) {
        st.pop();
      }
      if (!st.isEmpty()) {

        out[i] = st.peek();
      }
      st.push(arr[i]);
    }
    return out;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 6, 4, 10, 2, 5 };
    System.out.println(Arrays.toString(nextsmallerelement(arr)));
  }
}
