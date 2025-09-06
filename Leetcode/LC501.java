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
    int count =0;
    int maxcount =0;
    List<Integer> modes = new ArrayList<>();
    Integer prev = null;
    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] result = new int[modes.size()];
        for(int i=0;i<mode.size();i++) result[i]=modes.get(i);
        return result;
    }
    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(prev==null || root.val!=prev) count=1;
        else count++;
        if(count>maxcount){
            maxcount = count;
            modes.clear();
            modes.add(root.val);
        }else if(count==maxcount){
            modes.add(root.val);
        }
        prev = root.val;
        inorder(root.right);
    }
}