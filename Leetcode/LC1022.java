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
    public int sumRootToLeaf(TreeNode root) {
        return helper(root,0);
    }
    private int helper(TreeNode node,int current_sum){
        current_sum = 2*current_sum + node.val;
        if(node.left == null && node.right == null) return current_sum;
        int left = 0;
        int right = 0;
        if(node.left != null) left = helper(node.left,current_sum);
        if(node.right != null) right = helper(node.right,current_sum);
        return right + left;
    }
}