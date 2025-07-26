class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {
        return deleteHelper(root, key);
    }

    private TreeNode deleteHelper(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteHelper(root.left, key);
        } else if (key > root.val) {
            root.right = deleteHelper(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode successor = findSuccessor(root);
            root.val = successor.val;
            root.right = deleteHelper(root.right, successor.val);
        }

        return root;
    }
    private TreeNode findSuccessor(TreeNode node) {
        TreeNode curr = node.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
}
