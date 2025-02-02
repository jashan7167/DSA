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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
        {
            return null;
        }
        if(root.val==key)
        {
            if(root.left==null && root.right==null)
            {
                return null;
            }
            else if(root.right==null)
            {
                return root.left;
            }
            else  if(root.left==null)
            {
                return root.right;
            }
            else
            {
                TreeNode rightChild = root.right;
                TreeNode lastNode = findLastNode(root.left);
                lastNode.right = rightChild;
                return root.left;
            }
        }
        if(key<root.val)
        {
            root.left = deleteNode(root.left,key);
        }
        if(key>root.val)
        {
            root.right = deleteNode(root.right,key);
        }


        return root;
    }

    public TreeNode findLastNode(TreeNode root)
    {
        if(root.right==null)
        {
            return root;
        }

        return findLastNode(root.right);
    }
}