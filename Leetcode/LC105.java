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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }

        int leftSize = inIndex - inStart;

        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, inIndex - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, inIndex + 1, inEnd);

        return root;
    }
}



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
    Map<Integer, Integer> inorder_map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) inorder_map.put(inorder[i], i);
        
        return build(preorder, 0, n - 1, inorder, 0, n - 1);
    }
    private TreeNode build(int[] p, int pStart, int pEnd,int[] io, int inStart, int inEnd) {
        if (pStart > pEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(p[pStart]);
        int idx = inorder_map.get(p[pStart]);
        int leftSize = idx - inStart;
        root.left = build(p,pStart + 1,pStart + leftSize,io,inStart,idx - 1);
        root.right = build(p,pStart + leftSize + 1, pEnd,io,idx + 1,inEnd);
        return root;
    }
}