import java.util.Stack;
import java.util.Arrays;
public class nextsmallerelement {
  public static int[] nextsmallerelement(int[]arr)
  { 
    Stack<Integer> st = new Stack<Integer>();
    int[]out = new int[arr.length];
    Arrays.fill(out,-1);

    for(int i=0 ; i < arr.length ; i++)
    {
      while(!st.isEmpty() && st.peek()>=arr[i])
      { 
        st.pop();
      }
      if(!st.isEmpty())
      {

        out[i] = st.peek();
      }
      st.push(arr[i]);
    }
    return out;
  }
  public static void main(String[] args) {
    int [] arr = {4,5,2,10,8};
    System.out.println(Arrays.toString(nextsmallerelement(arr)));
  }
}
