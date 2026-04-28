class Solution {
    List<Integer> inOrder = new ArrayList<>();
    int idx;

    public TreeNode convertBST(TreeNode root) {
        Traverse(root);
        for (int i = inOrder.size() - 2; i >= 0; i--) {
            inOrder.set(i, inOrder.get(i) + inOrder.get(i + 1));
        }
        idx = 0;
        UpdateValues(root);
        return root;
    }

    public void Traverse(TreeNode root) {
        if (root != null) {
            Traverse(root.left);
            inOrder.add(root.val);
            Traverse(root.right);
        }
    }

    public void UpdateValues(TreeNode root) {
        if (root != null) {
            UpdateValues(root.left);
            root.val = inOrder.get(idx++);
            UpdateValues(root.right);
        }
    }
}

// better solution
class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        reverseInorder(root);
        return root;
    }
    private void reverseInorder(TreeNode node) {
        if (node == null) return;
        reverseInorder(node.right);
        sum += node.val;
        node.val = sum;
        reverseInorder(node.left);
    }
}


