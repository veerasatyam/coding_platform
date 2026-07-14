/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        inOrder(root,inorder);
        int i = 0;
        int j = inorder.size() - 1;
        while(i < j){
            int sum = inorder.get(i) + inorder.get(j);
            if(sum == k) return true;
            else if(sum > k) j--;
            else i++;
        }
        return false;
    }
    private void inOrder(TreeNode root,List<Integer> list){
        if(root != null){
            inOrder(root.left,list);
            list.add(root.val);
            inOrder(root.right,list);
        }
    }
}

// using BST iterator
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIteratorLeft left = new BSTIteratorLeft(root);
        BSTIteratorRight right = new BSTIteratorRight(root);
        int i = left.next();
        int j = right.next();
        while(i < j){
            int sum = i + j;
            if(sum == k) return true;
            else if(sum > k) j = right.next();
            else i = left.next();
        }
        return false;
    }
    class BSTIteratorLeft {
        Stack<TreeNode> stack = new Stack<>();
        public BSTIteratorLeft(TreeNode root) {
            pushAll(root);
        }

        public int next() {
            TreeNode tempNode = stack.pop();
            pushAll(tempNode.right);
            return tempNode.val;
        }

        private void pushAll(TreeNode node){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
        }
    }
    class BSTIteratorRight {
        Stack<TreeNode> stack = new Stack<>();
        public BSTIteratorRight(TreeNode root) {
            pushAll(root);
        }

        public int next() {
            TreeNode tempNode = stack.pop();
            pushAll(tempNode.left);
            return tempNode.val;
        }

        private void pushAll(TreeNode node){
            while(node != null){
                stack.push(node);
                node = node.right;
            }
        }
    }
}