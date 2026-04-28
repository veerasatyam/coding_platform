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
    List<Integer> inorder = new ArrayList<>();
    public int minDiffInBST(TreeNode root) {
        Traverse(root);
        int min = Integer.MAX_VALUE;
        for(int i = 1;i<inorder.size();i++){
            min = Math.min(min,inorder.get(i) - inorder.get(i-1));
        }
        return min;
    }
    private void Traverse(TreeNode root){
        if(root != null){
            Traverse(root.left);
            inorder.add(root.val);
            Traverse(root.right);
        }
    }
}