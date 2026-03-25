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
    int ans;

    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        rootsum(root);
        return ans;
    }

    int rootsum(TreeNode root) {
        if (root == null) return 0;

        int l = rootsum(root.left);
        int r = rootsum(root.right);

        int p = root.val;
        if (l > 0) p += l;
        if (r > 0) p += r;

        ans = Math.max(ans, p);

        return Math.max(0, Math.max(l, r)) + root.val;
    }
}



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
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
    private int dfs(TreeNode node) {
        if(node==null) return 0;
        int left=Math.max(0,dfs(node.left));
        int right=Math.max(0,dfs(node.right));
        maxSum=Math.max(maxSum,left+right+node.val);
     return node.val+Math.max(left,right);
    }
}