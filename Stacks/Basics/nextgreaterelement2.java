import java.util.Stack;
import java.util.Arrays;
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        Arrays.fill(output,-1);

        for(int i = 0 ; i < 2*n ; i++)
        {
            while(!st.isEmpty() && nums[st.peek()]<nums[i%n])
            {
                output[st.pop()] = nums[i%n];
            }
            st.push(i%n);
        }
    return output;
    }
}