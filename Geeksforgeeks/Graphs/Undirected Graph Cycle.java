import java.util.*;

class Solution {
    public boolean isCycle(int V, int[][] edges) {
        boolean[] visited = new boolean[V];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, adj, visited)) return true;
            }
        }
        return false;
    }
    private boolean dfs(int start, int parent, List<List<Integer>> adj, boolean[] visited) {
        visited[start] = true;
        for (int x : adj.get(start)) {
            if (!visited[x]) {
                if (dfs(x, start, adj, visited)) return true;
            } else if (x != parent) return true;
        }
        return false;
    }
}
