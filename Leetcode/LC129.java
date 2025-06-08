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
    public int sumNumbers(TreeNode root) {
       return allPath(root,0);
    }
    int allPath(TreeNode root,int sum)
    {
        if(root==null) return 0;
        sum = sum*10 + root.val;
        int l = allPath(root.left, sum);
        int r = allPath(root.right, sum);
        if(l+r==0) return sum;
        return l+r;
    }
}