class Solution {
    static int preIndex;
    static boolean checktree(int preorder[], int inorder[], int postorder[], int N) {
        preIndex = 0;
        TreeNode root = buildTree(preorder, inorder, 0, N - 1);
        if (root == null) return false;

        List<Integer> postList = new ArrayList<>();
        generatePostorder(root, postList);

        if (postList.size() != N) return false;

        for (int i = 0; i < N; i++) {
            if (postorder[i] != postList.get(i)) return false;
        }
        return true;
    }
    static TreeNode buildTree(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd || preIndex >= preorder.length) return null;

        int rootVal = preorder[preIndex++];
        TreeNode node = new TreeNode(rootVal);

        int index = findIndex(inorder, inStart, inEnd, rootVal);
        if (index == -1) return null;

        node.left = buildTree(preorder, inorder, inStart, index - 1);
        node.right = buildTree(preorder, inorder, index + 1, inEnd);
        return node;
    }
    static int findIndex(int[] arr, int start, int end, int key) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }
    static void generatePostorder(TreeNode root, List<Integer> post) {
        if (root == null) return;
        generatePostorder(root.left, post);
        generatePostorder(root.right, post);
        post.add(root.val);
    }
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }
}
