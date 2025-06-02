// A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class Solution {
    static int sumBT(Node root) {
        if(root==null) return 0;
        int ls = sumBT(root.left);
        int rs = sumBT(root.right);
        return ls+rs+root.data;
    }
}