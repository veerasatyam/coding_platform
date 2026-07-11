/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        Node predecessor = findPredecessor(root, key);
        Node successor = findSuccessor(root, key);
        return new ArrayList<>(Arrays.asList(predecessor, successor));
    }
    static Node findPredecessor(Node root, int key) {
        Node predecessor = null;
        while (root != null) {
            if (key > root.data) {
                predecessor = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return predecessor;
    }
    static Node findSuccessor(Node root, int key) {
        Node successor = null;
        while (root != null) {
            if (key < root.data) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor;
    }
}