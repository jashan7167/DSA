/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        // if(root==null) return false;
        // if(exists(head,root)) return true;
        // return isSubPath(head,root.left) || isSubPath(head,root.right);
        return exists2(head,head,root);

    }
    //exists works fine while exists2 doesnot
    public boolean exists(ListNode head, TreeNode root) {
        if (head== null)
            return true;
        if (root == null || head.val!=root.val)
            return false;
        return exists(head.next, root.left) || exists(head.next, root.right);
    }

    public boolean exists2(ListNode head,ListNode cur,TreeNode root)
    {
       if(cur == null) return true;
        if(root == null) return false;
        if(cur.val == root.val){
            cur = cur.next;
        }else if(head.val == root.val) head = head.next;
        else cur = head;
        boolean left = exists2(head,cur, root.left);
        boolean right = exists2(head,cur, root.right);
        return left || right;

}
}
