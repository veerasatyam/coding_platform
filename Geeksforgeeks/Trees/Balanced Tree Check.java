/*
class Node {
    int data;
    Node left, right;

    Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/
// naive approach O(n^2) time complexity
class Solution {
    public boolean isBalanced(Node root) {
        if(root == null) return true;
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left - right) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    private int height(Node root){
        if(root == null) return 0;
        return Math.max(height(root.left) , height(root.right)) + 1;
    }
}

// optimal solution 
class Solution {
    public boolean isBalanced(Node root) {
       return isBalancedRec(root) > 0;
    }
    private int isBalancedRec(Node root){
        if(root == null) return 0;
        int lHeight = isBalancedRec(root.left);
        int rHeight = isBalancedRec(root.right);

        if (lHeight == -1 || rHeight == -1 || Math.abs(lHeight - rHeight) > 1)
            return -1;

        return Math.max(lHeight, rHeight) + 1;
    }
}