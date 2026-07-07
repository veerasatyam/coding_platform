/*
Definition for Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int val)
    {
        this.data = val;
        left = null;
        right = null;
    }
}
*/
class Solution {
    static ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> Paths(Node root) {
        paths.clear();
        collectPaths(root, new ArrayList<>());
        return paths;
    }

    private static void collectPaths(Node root, ArrayList<Integer> path) {
        if (root == null) return;
        path.add(root.data);
        if (root.left == null && root.right == null) paths.add(new ArrayList<>(path));
        else {
            collectPaths(root.left, path);
            collectPaths(root.right, path);
        }
        path.remove(path.size() - 1);
    }
}