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
    class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode node,int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        if(root == null) return 0;
        q.add(new Pair(root, 0));
        int max = 0;
        while (!q.isEmpty()){
            int size = q.size();
            int first = 0,last = 0;
            for(int i = 0;i<size;i++){
                Pair x = q.poll();
                int index = x.idx;
                if(i == 0) first = index;
                if(i == size - 1) last = index;
                if(x.node.left != null) q.add(new Pair(x.node.left,2*index + 1));
                if(x.node.right != null) q.add(new Pair(x.node.right,2*index + 2));
            }
            max = Math.max(max, last - first + 1);
        }
        return max;
    }
}