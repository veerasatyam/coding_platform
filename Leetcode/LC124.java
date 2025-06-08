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
