import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class pair {
    Node temp;
    int col;

    pair(Node y, int x) {
        temp = y;
        col = x;
    }
}

class Solution {
    static ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<pair> q = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

        int minl = 0, maxl = 0;
        q.add(new pair(root, 0));

        while (!q.isEmpty()) {
            pair p = q.poll();
            Node t = p.temp;
            int c = p.col;

            if (!hm.containsKey(c)) {
                hm.put(c, new ArrayList<>());
            }

            hm.get(c).add(t.data);
            minl = Math.min(minl, c);
            maxl = Math.max(maxl, c);

            if (t.left != null) q.add(new pair(t.left, c - 1));
            if (t.right != null) q.add(new pair(t.right, c + 1));
        }

        for (int i = minl; i <= maxl; i++) {
            result.add(hm.get(i));
        }

        return result;
    }
}
