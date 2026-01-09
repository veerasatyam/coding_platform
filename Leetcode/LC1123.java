//reference: https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/solutions/2950735/java-dfs-solution-with-explanation/

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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int maxDepth = getDepth(root);
        return dfs(root, maxDepth, 1);
    }
    private int getDepth(TreeNode root){
        if(root==null) return 0;
        return Math.max(getDepth(root.left),getDepth(root.right)) + 1;
    }
    private TreeNode dfs(TreeNode root,int depth,int currDepth){
        if(root==null) return null;
        if(currDepth==depth) return root;
        TreeNode left = dfs(root.left,depth,currDepth+1);
        TreeNode right = dfs(root.right,depth,currDepth+1);
        if(left!=null && right!=null) return root;
        if(left!=null) return left;
        return right;
    }
}
