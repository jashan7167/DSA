/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int topRow = 0, bottomRow = m - 1, leftColumn = 0, rightColumn = n - 1;
        int[][] mat = new int[m][n];
        ListNode ptr = head;
        for (int[] a : mat) {
            Arrays.fill(a, -1);
        }
        while (ptr != null) {
            // going from left to right top
            for (int col = leftColumn; col <= rightColumn && ptr != null; col++) {
                int data = ptr.val;
                mat[topRow][col] = data;
                ptr = ptr.next;
            }
            topRow++;
            // go down from top row to bottom
            for (int row = topRow; row <= bottomRow & ptr != null; row++) {
                mat[row][rightColumn] = ptr.val;
                ptr = ptr.next;
            }
            // go from right to left bottom
            rightColumn--;
            for (int col = rightColumn; col >= leftColumn && ptr != null; col--) {
                mat[bottomRow][col] = ptr.val;
                ptr = ptr.next;
            }
            bottomRow--;
            // go from the bottomRow,leftColumn which is now decreased top Row
            for (int row = bottomRow; row >= topRow && ptr != null; row--) {
                mat[row][leftColumn] = ptr.val;
                ptr = ptr.next;
            }
            leftColumn++;
        }
        return mat;
    }
}
