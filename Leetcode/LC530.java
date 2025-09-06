// class Solution {
//     List<Integer> order = new ArrayList<>();
    
//     public int getMinimumDifference(TreeNode root) {
//         inorder(root);
//         int minDiff = Integer.MAX_VALUE;
//         for (int i = 1; i < order.size(); i++) {
//             minDiff = Math.min(minDiff, order.get(i) - order.get(i - 1));
//         }
//         return minDiff;
//     }

//     private void inorder(TreeNode root) {
//         if (root == null) return;
//         inorder(root.left);
//         order.add(root.val);
//         inorder(root.right);
//     }
// }


//using O(1) space 
class Solution {
    private int min = Integer.MAX_VALUE, prev = -1;
    private void find(TreeNode root) {
        if (root == null)
            return;
        find(root.left);
        if (prev >= 0 && min > root.val - prev)
            min = root.val - prev;
        prev = root.val;
        find(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        find(root);
        return min;
    }
}
