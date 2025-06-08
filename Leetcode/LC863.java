import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    List<TreeNode> path = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        findPath(root, target);
        if (path.size() == 0) return ans;

        addBelow(path.get(0), k, ans);
        int d = k - 1;

        for (int i = 1; i < path.size(); i++) {
            if (d == 0) {
                ans.add(path.get(i).val);
                break;
            }

            TreeNode parent = path.get(i);
            TreeNode child = path.get(i - 1);

            if (parent.left == child) {
                addBelow(parent.right, d - 1, ans);
            } else {
                addBelow(parent.left, d - 1, ans);
            }

            d--;
        }

        return ans;
    }

    private boolean findPath(TreeNode node, TreeNode target) {
        if (node == null) return false;
        if (node == target) {
            path.add(node);
            return true;
        }

        if (findPath(node.left, target) || findPath(node.right, target)) {
            path.add(node);
            return true;
        }

        return false;
    }

    private void addBelow(TreeNode node, int k, List<Integer> ans) {
        if (node == null || k < 0) return;
        if (k == 0) {
            ans.add(node.val);
            return;
        }
        addBelow(node.left, k - 1, ans);
        addBelow(node.right, k - 1, ans);
    }
}
