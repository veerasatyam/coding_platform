
// reference: https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/solutions/2950733/java-python-c-dfs-with-pair-class-clean-and-e


class Solution {
    class pair{
        TreeNode node;
        int depth;
        pair(TreeNode n,int d){
            node=n;
            depth=d;
        }
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
    private pair dfs(TreeNode root){
        if(root==null) return new pair(root,0);
        pair left = dfs(root.left);
        pair right = dfs(root.right);
        if(left.depth > right.depth) return new pair(left.node,left.depth+1);
        else if(left.depth < right.depth) return new pair(right.node,right.depth+1);
        else return new pair(root,left.depth+1);
    }
}


// another approach
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int maxDepth = getDepth(root);
        return dfs(root, maxDepth, 1);
    }
    private int getDepth(TreeNode root){
        if(root==null) return 0;
        return Math.max(getDepth(root.left),getDepth(root.right)) + 1
    }
    private TreeNode dfs(TreeNode root,int depth,int currDepth){
        if(root==null) return null;
        if(currDepth==depth) return root;
        TreeNode left = dfs(root.left,depth,currDepth+1);
        TreeNode right = dfs(root.right,depth,currDepth+1);
        if(left!=null && right!=null) return root;
        if(left!=null) return left;
        return right;
    }
}



