class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for (int i = 0;i < n;i++)map.put(inorder[i], i);
        return build(inorder, 0, n - 1, postorder, 0, n - 1);
    }
    private TreeNode build(int[] inorder, int oStart, int oEnd,int[] postorder, int pStart, int pEnd){
        if (oStart > oEnd || pStart > pEnd) return null;
        int rootVal = postorder[pEnd];
        TreeNode root = new TreeNode(rootVal);
        int idx = map.get(rootVal);
        int leftSize = idx - oStart;
        root.left = build(inorder, oStart, idx - 1,postorder, pStart, pStart + leftSize - 1);
        root.right = build(inorder, idx + 1,oEnd,postorder, pStart + leftSize, pEnd - 1);
        return root;
    }
}