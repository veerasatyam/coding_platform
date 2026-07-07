import java.util.*;
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class Solution {
    class Pair {
        Node node;
        int data;
        Pair(Node node, int data) {
            this.node = node;
            this.data = data;
        }
    }
    public List<List<Integer>> preInPostTraversal(Node root) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        if (root == null) return new ArrayList<>();
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));
        while (!st.empty()) {
            Pair it = st.pop();
            if (it.data == 1) {
                pre.add(it.node.data);
                it.data = 2;
                st.push(it);
                if (it.node.left != null) {
                    st.push(new Pair(it.node.left, 1));
                }
            }
            else if (it.data == 2) {
                in.add(it.node.data);
                it.data = 3;
                st.push(it);
                if (it.node.right != null) {
                    st.push(new Pair(it.node.right, 1));
                }
            }
            else {
                post.add(it.node.data);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(pre);
        result.add(in);
        result.add(post);
        return result;
    }

    public void printList(List<Integer> list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}