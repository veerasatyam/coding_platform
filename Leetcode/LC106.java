class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, 
                     postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd, 
                           int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return null;

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                inIndex = i;
                break;
            }
        }

        int leftSize = inIndex - inStart;

        root.left = build(inorder, inStart, inIndex - 1, 
                          postorder, postStart, postStart + leftSize - 1);
        
        root.right = build(inorder, inIndex + 1, inEnd, 
                           postorder, postStart + leftSize, postEnd - 1);
        
        return root;
    }
}
