import java.util.*;

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
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> lis = new ArrayList<>();
        inOrder(root,lis);
        return BuildTree(lis,0,lis.size()-1);
    }
    private void inOrder(TreeNode root,List<TreeNode> lis){
        if(root==null) return;
        inOrder(root.left,lis);
        lis.add(root);
        inOrder(root.right,lis);
    }
    private TreeNode BuildTree(List<TreeNode> list,int start,int end){
         if(start>end) return null;
        int mid = (start + end)/2;
        TreeNode node = new TreeNode(list.get(mid).val);
        node.left = BuildTree(list,start,mid-1);
        node.right = BuildTree(list,mid+1,end);
        return node;
    }
}