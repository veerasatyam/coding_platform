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



// using bfs
import java.util.*;

class Solution {
    
    class Pairs {
        int node;
        int parent;
        Pairs(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public boolean isCycle(int V, int[][] edges) {
        boolean[] visited = new boolean[V];
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        for(int i = 0; i < V; i++){
            if(!visited[i]){
                if(bfs(i, adj, visited)) return true;
            }
        }
        return false;
    }

    private boolean bfs(int start, List<List<Integer>> adj, boolean[] visited){
        Queue<Pairs> q = new LinkedList<>();
        q.add(new Pairs(start, -1));
        visited[start] = true;

        while(!q.isEmpty()){
            Pairs x = q.poll();
            int node = x.node;
            int parent = x.parent;

            for(int it : adj.get(node)){
                if(it != parent){
                    if(visited[it]) return true;
                    visited[it] = true;
                    q.add(new Pairs(it, node));
                }
            }
        }
        return false;
    }
}