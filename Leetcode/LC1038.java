class Solution {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        reverseInorder(root);
        return root;
    }
    private void reverseInorder(TreeNode node) {
        if (node == null) return;
        reverseInorder(node.right);
        sum += node.val;
        node.val = sum;
        reverseInorder(node.left);
    }
}
