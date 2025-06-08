import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class Solution {
    List<Integer> res;

    public int[] solve(TreeNode A, int B) {
        res = new ArrayList<>();
        findPath(A, B);
        int[] result = new int[res.size()];
         for (int i = 0; i < res.size(); i++) {
               result[i] = res.get(i);
                }
            return result;

    }

    private boolean findPath(TreeNode root, int B) {
        if (root == null) return false;
        res.add(root.val);
        if (root.val == B) return true;
        
        if (findPath(root.left, B) || findPath(root.right, B))
            return true;
        res.remove(res.size() - 1);
        return false;
    }
}
