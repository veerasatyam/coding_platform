// tarjan's algorithm to find articulation points in an undirected graph
// keyword: Tarjan's Algorithm, DFS, Graph Theory, Articulation Points
// important points:
// 1. The problem is to find all articulation points in an undirected graph.
// 2. An articulation point is a vertex that, if removed along with its associated edges, increases the number of connected components in the graph.

class Solution {
    static int timer = 1;
    static void dfs(int node,int parent,int[] vis,int[] tin,int[] low,int[] mark,List<List<Integer>> adj){
        vis[node] = 1;
        tin[node] = low[node] = timer++;
        int child = 0;
        for(Integer it : adj.get(node)){
            if(it==parent) continue;
            if(vis[it] == 0){
                dfs(it,node,vis,tin,low,mark,adj);
                low[node] = Math.min(low[node],low[it]);
                if(low[it] >= tin[node] && parent != -1){
                    mark[node] = 1;
                }
                child++;
            }
            else{
                low[node] = Math.min(low[node],tin[it]);
            }
            if(child > 1 && parent == -1){
                mark[node] = 1;
            }
        }
    }
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        int[] vis = new int[V];
        int[] tin = new int[V];
        int[] low  = new int[V];
        int[] mark = new int[V];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        for(int i=0;i<V;i++) if(vis[i]==0) dfs(i,-1,vis,tin,low,mark,adj);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<V;i++) if(mark[i]==1) ans.add(i);
        if(ans.size()==0) ans.add(-1);
        return ans;
    }
}