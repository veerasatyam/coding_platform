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
import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        findPaths(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void findPaths(TreeNode node, int remainingSum, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        path.add(node.val);

        if (node.left == null && node.right == null && node.val == remainingSum) {
            result.add(new ArrayList<>(path));
        } else {
            findPaths(node.left, remainingSum - node.val, path, result);
            findPaths(node.right, remainingSum - node.val, path, result);
        }
        path.remove(path.size() - 1);
    }
}



// my version of code

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
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root,0,targetSum,new ArrayList<>());
        return result;
    }
    private void helper(TreeNode root,int curr,int target,ArrayList<Integer> current){
        if(root == null) return;
       if(root.left == null && root.right == null){
            if(root.val + curr == target){
                current.add(root.val);
                result.add(new ArrayList<>(current));
                current.remove(current.size() - 1);
            }
            return;
        }
        current.add(root.val);
        curr = curr + root.val;
        helper(root.left,curr,target,current);
        helper(root.right,curr,target,current);
        current.remove(current.size()-1);
    }
}