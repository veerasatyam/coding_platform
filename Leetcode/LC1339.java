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
    long max = 0;
    static final int MOD = 1_000_000_007;
    public int maxProduct(TreeNode root) {
        long total = treeSum(root);
        dfs(root, total);
        return (int)(max % MOD);
    }
    private long treeSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + treeSum(root.left) + treeSum(root.right);
    }

    private long dfs(TreeNode root,long total) {
        if (root == null) return 0;
        long left = dfs(root.left,total);
        long right = dfs(root.right,total);
        long sub = root.val + left + right;
        max = Math.max(max,sub * (total-sub));
        return sub;
    }
}









class Solution {
    long max = 0;
    static final int MOD = 1_000_000_007;
    public int maxProduct(TreeNode root) {
        Find_sum(root);       
        int total_sum = root.val;
        maxProduct(root, total_sum);
        return (int)(max % MOD);
    }

    private void Find_sum(TreeNode root) {
        if (root == null) return;
        Find_sum(root.left);
        Find_sum(root.right);
        int leftSum = root.left != null ? root.left.val : 0;
        int rightSum = root.right != null ? root.right.val : 0;
        root.val = root.val + leftSum + rightSum;
    }
    private void maxProduct(TreeNode root, int totalSum) {
        if (root == null) return;
        long product = (long)root.val*(totalSum-root.val);
        max = Math.max(max, product);
        maxProduct(root.left, totalSum);
        maxProduct(root.right, totalSum);
    }
}
