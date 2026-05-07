/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/
class Solution {
   static boolean areIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return (root1.data == root2.data && areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right));
    }

    static boolean isSubtree(Node root1, Node root2) {
        if (root2 == null)
            return true;
       if (root1 == null)return false;
        if (areIdentical(root1, root2))return true;
        return isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
    }
}



// serializabiliy approach
/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/
class Solution {
   static void serialize(Node root, StringBuilder s){
        if (root == null) {
            s.append("# ");
            return;
        }
        s.append(root.data).append(" ");
        serialize(root.left, s);
        serialize(root.right, s);
    }

    static boolean isSubTree(Node root1, Node root2){
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        serialize(root1,s1);
        serialize(root2,s2);
        return s1.toString().contains(s2.toString());
    }

}




// fastser way to find wheather the string a is a substring of b or not using KMP alogorithm
