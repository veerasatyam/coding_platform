class Solution {
    public boolean isSumTree(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        if (root.data == leftSum + rightSum &&
            isSumTree(root.left) && isSumTree(root.right)) {
            return true;
        }

        return false;
    }

    private int sum(Node node) {
        if (node == null) return 0;
        return sum(node.left) + sum(node.right) + node.data;
    }
}
