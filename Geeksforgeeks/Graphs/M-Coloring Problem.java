import java.util.*;

class Solution {
    public boolean graphColoring(int v, int[][] edges, int m) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0;i<v;i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int[] colors = new int[v];
        Arrays.fill(colors, -1);
        return generateColors(0, m, adj, colors);
    }

    private boolean generateColors(int vertex, int m, List<List<Integer>> adj, int[] colors) {
        if (vertex == adj.size()) return true;
        for (int col = 0;col<m;col++){
            if (isSafe(vertex,col,adj,colors)){
                colors[vertex] = col;
                if (generateColors(vertex + 1,m,adj,colors)) return true;
                colors[vertex] = -1;
            }
        }
        return false;
    }
    private boolean isSafe(int vertex, int col, List<List<Integer>> adj, int[] colors) {
        for (int nei : adj.get(vertex)) {
            if (colors[nei] == col) return false;
        }
        return true;
    }
}