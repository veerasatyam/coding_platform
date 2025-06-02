class Solution {
    public static int findMax(Node root) {
        if(root==null) return 0;
        int lm = findMax(root.left);
        int rm = findMax(root.right);
        return Math.max(lm, Math.max(rm,root.data));
    }

    public static int findMin(Node root) {
        if(root==null) return Integer.MAX_VALUE;
        int lm = findMin(root.left);
        int rm = findMin(root.right);
        return Math.min(lm, Math.min(rm,root.data));
    }
}