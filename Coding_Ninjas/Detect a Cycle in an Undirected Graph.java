import java.util.List;
public class Solution {
    class Pair{
        int curr,parent;
        Pair(int curr,int parent){
            this.curr = curr;
            this.parent =parent;
        }
    }
    private boolean checkCycle( List<List<Integer>> adj,int V,int i,boolean[] visited){
        visited[i] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,-1));
        while(!q.isEmpty()){
            Pair x = q.remove();
            int src = x.curr;
            int p = x.parent;
            for(int adjNode : adj.get(src)){
                if(visited[adjNode]==false){
                    visited[adjNode] = true;
                    q.add(new Pair(adjNode,src));
                }else{
                    if(p != adjNode) return true;
                }
            }
        }
        return false;
    }
    static class Graph {
        boolean detectCycle(int V, List<List<Integer>> adj) {
            boolean[] visited = new boolean[V+1];
            for(int i=0;i<V;i++){
                if(visited[i]==false){
                    if(checkCycle(adj,V,i,visited)) return true;
                }
            }
            return false;
        }
    };
}


// using DFS
import java.util.*;
public class Solution {
    static class Graph {
        private boolean dfs(List<List<Integer>> adj, int src, int parent, boolean[] visited) {
                visited[src] = true;
                for (int a : adj.get(src)) {
                    if (!visited[a]) {
                        if (dfs(adj,a,src,visited)) return true;
                    } else if (a!=parent) {
                        return true;
                    }
                }
                return false;
         }
        boolean detectCycle(int V, List<List<Integer>> adj) {
            boolean[] visited = new boolean[V];
            for(int i = 0; i < V; i++){
                if(!visited[i]){
                    if(dfs(adj,i,-1,visited)) return true;
                }
            }
            return false;
        }
    }
}

