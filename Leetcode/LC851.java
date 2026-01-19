class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] r : richer) {
            adj.get(r[1]).add(r[0]);
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
            ans[i] = dfs(i, adj, quiet, ans);
        }
        return ans;
    }
    private int dfs(int node, List<List<Integer>> adj, int[] quiet, int[] ans) {
        if (ans[node] != -1) return ans[node];
        ans[node] = node;
        for (int neighbor : adj.get(node)) {
            int candidate = dfs(neighbor, adj, quiet, ans);
            if (quiet[candidate] < quiet[ans[node]]) {
                ans[node] = candidate;
            }
        }
        return ans[node];
    }
}
