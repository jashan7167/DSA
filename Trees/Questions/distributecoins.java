/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int res=0;;
   
    public int distributeCoins(TreeNode root) {
        distcoins(0,root);
        return res;
    }

    public int distcoins(int extra_coins,TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }

        int l_extra = distcoins(extra_coins,root.left);
        int r_extra = distcoins(extra_coins,root.right);

        extra_coins = root.val - 1 + l_extra + r_extra;

        res+=Math.abs(extra_coins);

        return extra_coins;

    }
}