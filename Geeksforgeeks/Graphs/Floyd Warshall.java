// Floyd–Warshall finds shortest paths between **all pairs of vertices** using dynamic programming, runs in `O(n³)`, uses an adjacency matrix, and can handle negative edges but not negative cycles.
// It is best suited for **small or dense graphs** where all-pairs distances are required.
// Dijkstra’s algorithm finds shortest paths from **a single source**, runs faster with `O((V+E) log V)`, and uses a greedy approach with a priority queue.
// Unlike Floyd–Warshall, Dijkstra **cannot handle negative edge weights**, but it scales far better for large sparse graphs.


class Solution {
    public void floydWarshall(int[][] dist) {
        int n = dist.length;
        int INF = 100000000;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 0; j < n; j++) {
                    if (dist[k][j] == INF) continue;
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }
}
