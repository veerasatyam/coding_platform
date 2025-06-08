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
     static boolean isbalanced;
     int Height(TreeNode root)
     {
        if(root==null) return 0;
        int lh = Height(root.left);
        int rh = Height(root.right);
        int d = Math.abs(lh-rh);
        if(d>1) isbalanced = false;
        return Math.max(lh,rh)+1;
     }
    public boolean isBalanced(TreeNode root) {
        isbalanced = true;
        Height(root);
        return isbalanced;
    }
}