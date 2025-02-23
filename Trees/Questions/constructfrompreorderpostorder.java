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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer,Integer> postorderhashmap = new HashMap<>();
        for(int i = 0 ; i < postorder.length ; i++)
        {
            postorderhashmap.put(postorder[i],i);
        }
        int n = postorder.length;
        return construct(0,n-1,0,n-1,postorderhashmap,preorder);
    }
    public TreeNode construct(int i1 , int i2 , int j1 , int j2 , HashMap<Integer,Integer>postorderhashmap , int[]preorder)
    {
        if(i1>i2 || j1>j2)
        {
            return null;
        }
            TreeNode root = new TreeNode(preorder[i1]);
            if(i1!=i2)
            {
                int leftval = preorder[i1+1];
                int m = postorderhashmap.get(leftval);
                int length = m - j1 + 1;
                root.left = construct(i1+1,i1+length,j1,m,postorderhashmap,preorder);
                root.right = construct(i1+length+1,i2,m+1,j2,postorderhashmap,preorder);
            }
            return root;
    }
}
