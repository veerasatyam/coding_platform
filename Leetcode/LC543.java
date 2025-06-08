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
    int res = 0;

    int Height(TreeNode root) {
        if (root == null) return 0;
        int lh = Height(root.left);
        int rh = Height(root.right);
        int d = lh + rh + 1;
        res = Math.max(d, res);
        return Math.max(lh, rh) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        Height(root);
        return res - 1;
    }
}
