/*
class Node{
    int data;
    Node left, right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class Solution {
    public boolean isSumProperty(Node root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        int sum = 0;
        if (root.left != null) sum += root.left.data;
        if (root.right != null)sum += root.right.data;
        return ((root.data == sum) && (isSumProperty(root.left)) && (isSumProperty(root.right))) ;
    }
}








// if you want to change the entire binary tree which can obey the childer sum in a binary tree and you can increase the node values any number of times
class solution{
    public static void changeTree(Node root){
        if(root == null) return;
        int child = 0;
        if(root.left != null) child += root.left.data;
        if(root.right != null) child += root.right.data;
        if(child >= root.data) root.data = child;
        else{
            if(root.left != null) root.left.data = root.data;
            else if(root.right != null) root.right.data = root.data;
        }
        changeTree(root.left);
        changeTree(root.right);
        int tot = 0;
        if(root.left != null) tot += root.left.data;
        if(root.right != null) tot += root.right.data;
        if(root.left != null || root.right != null) root.data = tot;
    }
}