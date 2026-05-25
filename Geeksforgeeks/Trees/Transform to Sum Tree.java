/* Structure for Tree Node
class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
};
*/
class Solution {
   static HashMap<Node,Integer> map = new HashMap<>();
    public void toSumTree(Node root) {
        storeSum(root);
        update(root);
    }
    private static int storeSum(Node root){
        if(root == null) return 0;
        int leftSum = storeSum(root.left);
        int rightSum = storeSum(root.right);
        int sum = leftSum + rightSum + root.data;
        map.put(root,sum);
        return sum; 
    }
    private static void update(Node root){
        if(root == null) return;
        int leftSum = map.getOrDefault(root.left,0);
        int rightSum = map.getOrDefault(root.right,0);
        root.data = leftSum + rightSum;
        update(root.left);
        update(root.right);
    }
}



// expected approach
/* Structure for Tree Node
class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
};
*/
class Solution {
    public void toSumTree(Node root) {
       solve(root);   
    }
    private static int solve(Node root){
        if(root == null) return 0;
        int leftSum = solve(root.left);
        int rightSum = solve(root.right);
        int oldValue = root.data;
        root.data = leftSum + rightSum;
        return oldValue + leftSum + rightSum; 
    }
}