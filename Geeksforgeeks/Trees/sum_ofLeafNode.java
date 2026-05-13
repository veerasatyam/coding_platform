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
*/

class Solution {
    static int leafSum(Node root) {  
    if (root == null) return 0;
    if (root.left == null && root.right == null) {
        return root.data;
    }
    int ls = leafSum(root.left);
    int rs = leafSum(root.right);
    return ls + rs;
    }
}