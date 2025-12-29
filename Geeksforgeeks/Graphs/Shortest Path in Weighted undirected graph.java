class Solution {
    class Pairs {
        int dist, node;
        Pairs(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }
    }
    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        List<List<Pairs>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pairs(edges[i][2], edges[i][1]));
            adj.get(edges[i][1]).add(new Pairs(edges[i][2], edges[i][0]));
        }
        PriorityQueue<Pairs> pq =new PriorityQueue<>((a, b) -> a.dist - b.dist);
        int[] distance = new int[n + 1];
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }
        distance[1] = 0;
        pq.add(new Pairs(0, 1));
        while (!pq.isEmpty()) {
            Pairs x = pq.poll();
            int nx = x.node;
            int d = x.dist;
            if (d > distance[nx]) continue;
            for (Pairs iter : adj.get(nx)) {
                int adjNode = iter.node;
                int edw = iter.dist;
                if (d + edw < distance[adjNode]) {
                    distance[adjNode] = d + edw;
                    pq.add(new Pairs(d + edw, adjNode));
                    parent[adjNode] = nx;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
            if (distance[n] == Integer.MAX_VALUE) {
                path.add(-1);
                return path;
            }
            int node = n;
            while (parent[node] != node) {
                path.add(node);
                node = parent[node];
            }
            path.add(1);
            Collections.reverse(path);
            path.add(0, distance[n]);
            return path;
    }
}
