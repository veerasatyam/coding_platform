/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/


class Solution {
    static boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }

    static void addLeftBoundary(Node root, List<Integer> res) {
        Node curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) res.add(curr.data);
            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }

    static void addLeaves(Node root, List<Integer> res) {
        if (root == null) return;
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        addLeaves(root.left, res);
        addLeaves(root.right, res);
    }

    static void addRightBoundary(Node root, List<Integer> res) {
        Node curr = root.right;
        Stack<Integer> temp = new Stack<>();
        while (curr != null) {
            if (!isLeaf(curr)) temp.push(curr.data);
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        while (!temp.isEmpty()) {
            res.add(temp.pop());
        }
    }

    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        if (!isLeaf(root)) res.add(root.data);

        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);

        return res;
    }
}