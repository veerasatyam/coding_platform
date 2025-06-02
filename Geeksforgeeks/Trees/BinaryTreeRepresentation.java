import java.util.ArrayList;

class Node{
    int data;
    Node left,right;
    Node(int val)
    {
        data = val;
        left=null;
        right=null;
    }
}

class Solution {
    public static void createTree(Node root0, ArrayList<Integer> v) {
        buildTree(root0, v, 0);
    }
    private static void buildTree(Node root,ArrayList<Integer> v,int i)
    {
        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;
        if (leftIndex < v.size()) {
            root.left = new Node(v.get(leftIndex));
            buildTree(root.left, v, leftIndex);
        }
         if (rightIndex < v.size()) {
            root.right = new Node(v.get(rightIndex));
            buildTree(root.right, v, rightIndex);
        }
    }
}