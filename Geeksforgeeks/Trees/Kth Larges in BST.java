/* Structure of a Binary Tree Node
class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
};*/

class Solution {
    public int kthLargest(Node root, int k) {
         Stack<Node> st = new Stack<>();
        Node curr = root;
        int count = 0;
        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.right;
            }
            curr = st.pop();
            count++;
            if (count == k)return curr.data;
            curr = curr.left;
        }
        return -1;
    }
}