import java.util.ArrayList;
import java.util.LinkedList;

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
    ArrayList<Integer> large;

    public List<Integer> largestValues(TreeNode root) {
        large = new ArrayList<>();
        if (root == null) return large;
        findLargest(root, large);
        return large;
    }

    void findLargest(TreeNode root, ArrayList<Integer> large) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (q.size() > 0) {
            int size = q.size();
            int maxVal = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.val > maxVal) maxVal = node.val;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            large.add(maxVal);
        }
    }
}
