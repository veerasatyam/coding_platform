import java.util.*;

class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Trie t = new Trie();

        int n = queries.length;
        int[][] queries_modify = new int[n][3];
        for (int i = 0; i < n; i++) {
            queries_modify[i][0] = queries[i][0];
            queries_modify[i][1] = queries[i][1];
            queries_modify[i][2] = i;
        }

        Arrays.sort(nums);
        Arrays.sort(queries_modify, (a, b) -> a[1] - b[1]);
        int[] ans = new int[n];
        int idx = 0;
        for (int[] q : queries_modify) {
            int xi = q[0];
            int m = q[1];
            while (idx < nums.length && nums[idx] <= m) {
                t.insert(nums[idx]);
                idx++;
            }
            if (idx == 0) {
                ans[q[2]] = -1;
            } else {
                ans[q[2]] = t.findMax(xi);
            }
        }
        return ans;
    }
}

class Node {
    Node[] links = new Node[2];

    boolean containsKey(int bit) {
        return links[bit] != null;
    }

    Node get(int bit) {
        return links[bit];
    }

    void put(int bit, Node node) {
        links[bit] = node;
    }
}
class Trie {
    Node root;
    Trie() {
        root = new Node();
    }
    public void insert(int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }
    public int findMax(int num) {
        Node node = root;
        int maxXor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.containsKey(1 - bit)) {
                maxXor |= (1 << i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }
        return maxXor;
    }
}