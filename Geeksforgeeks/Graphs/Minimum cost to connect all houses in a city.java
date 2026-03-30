import java.util.*;

class Solution {
    class Pair {
        int node;
        int distance;
        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
    private int calculate(int x1, int x2, int y1, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public int minCost(int[][] houses) {
        int n = houses.length;

        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)adj.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int dist = calculate(houses[i][0],houses[j][0],houses[i][1],houses[j][1]);
                adj.get(i).add(new Pair(j,dist));
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        boolean[] visited = new boolean[n];
        pq.add(new Pair(0, 0));
        int total = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int dist = curr.distance;
            if (visited[node]) continue;
            visited[node] = true;
            total += dist;
            for (Pair nei : adj.get(node)) {
                if (!visited[nei.node]) {
                    pq.add(nei);
                }
            }
        }
        return total;
    }
}