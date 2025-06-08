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
    public int maxAncestorDiff(TreeNode root) {
        return helper(root, root.val, root.val);
    }

    private int helper(TreeNode node, int currentMax, int currentMin) {
        if (node == null) {
            return currentMax - currentMin;
        }

        currentMax = Math.max(currentMax, node.val);
        currentMin = Math.min(currentMin, node.val);

        int leftDiff = helper(node.left, currentMax, currentMin);
        int rightDiff = helper(node.right, currentMax, currentMin);

        return Math.max(leftDiff, rightDiff);
    }
}
