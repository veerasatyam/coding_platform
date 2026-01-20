// keyword: Tarjan's Algorithm, DFS, Graph Theory, Bridges in Graphs
// important points:
// 1. The problem is to find all critical connections (bridges) in an undirected graph.
// 2. A critical connection is an edge that, if removed, will increase the number of connected components in the graph.
// 3. The solution uses Tarjan's algorithm, which employs DFS to find bridges by tracking discovery and low-link values.

class Solution {
    private int timer = 1;
    private void dfs(int node,int parent,int[] visited,int[] tin,int[] low,List<List<Integer>> adj,List<List<Integer>> result){
        visited[node]  = 1;
        tin[node] = low[node] = timer++;
        for(Integer it : adj.get(node)){
            if(it == parent) continue;
            if(visited[it] == 0){
                dfs(it,node,visited,tin,low,adj,result);
                low[node] = Math.min(low[node],low[it]);
                if(low[it] > tin[node]){
                    result.add(Arrays.asList(node,it));
                }
            }else{
                low[node] = Math.min(low[node],tin[it]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (List<Integer> conn : connections) {
            adj.get(conn.get(0)).add(conn.get(1));
            adj.get(conn.get(1)).add(conn.get(0));
        }
        List<List<Integer>> result = new ArrayList<>();
        int[] visited = new int[n];
        int[] tin = new int[n];
        int[] low  = new int[n];
        dfs(0,-1,visited,tin,low,adj,result);
        return result;
    }
}