import java.util.*;
class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        // Calculate left numsay
        for (int i = 0; i < n; i++) {
            while (!s1.isEmpty() && nums[s1.peek()] >= nums[i]) {
                s1.pop();
            }
            left[i] = s1.isEmpty() ? i + 1 : i - s1.peek();
            s1.push(i);
        }

        // Calculate right numsay
        for (int i = n - 1; i >= 0; i--) {
            while (!s2.isEmpty() && nums[s2.peek()] > nums[i]) {
                s2.pop();
            }
            right[i] = s2.isEmpty() ? n - i : s2.peek() - i;
            s2.push(i);
        }

        long y = 0;

        for (int i = 0; i < n; ++i) {
            y = (y + (long) nums[i] * left[i] * right[i]);
        }
        long x = sumofsubarraymax(nums);

        return x - y;
        
    }
    public static long sumofsubarraymax(int[]nums)
    {
     int n = nums.length;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int leftmax[] = new int[n];
        int rightmax[] = new int[n];

    //calculate the sum of subnumsay maximums

          // Calculate left numsay
        for (int i = 0; i < n; i++) {
            while (!s1.isEmpty() && nums[s1.peek()] <= nums[i]) {
                s1.pop();
            }
            leftmax[i] = s1.isEmpty() ? i + 1 : i - s1.peek();
            s1.push(i);
        }
        for(int a:leftmax)
        {
            System.out.println(a);
        }

        // Calculate right array
        for (int i = n - 1; i >= 0; i--) {
            while (!s2.isEmpty() && nums[s2.peek()] < nums[i]) {
                s2.pop();
            }
            rightmax[i] = s2.isEmpty() ? n - i : s2.peek() - i;
            s2.push(i);
        }
         for(int a:rightmax)
        {
            System.out.println(a);
        }

        long x = 0;

          for (int i = 0; i < n; ++i) {
            x = (x + (long) nums[i] * leftmax[i] * rightmax[i]);
        }
        return x;
    }
}