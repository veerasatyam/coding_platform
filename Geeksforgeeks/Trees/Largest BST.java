// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {

    static int largestBst(Node root) {
        if (root == null) return 0;
        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return size(root);
        }
        return Math.max(largestBst(root.left), largestBst(root.right));
    }

    static boolean isBST(Node node, int min, int max) {
        if (node == null) return true;
        if (node.data <= min || node.data >= max) return false;
        return isBST(node.left, min, node.data) && isBST(node.right, node.data, max);
    }

    static int size(Node node) {
        if (node == null) return 0;
        return 1 + size(node.left) + size(node.right);
    }
}