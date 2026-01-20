// kosaraju's algorithm to find strongly connected components in a directed graph
import java.util.*;
class Solution {
    private void dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] visited,Stack<Integer> stack){
        visited[node] = 1;
        for(Integer neighbor : adj.get(node)){
            if(visited[neighbor]==0) dfs(neighbor,adj,visited,stack);
        }
        stack.push(node);
    }
    private void dfsK(int node, List<List<Integer>> revAdj, int[] visited) {
        visited[node] = 1;
        for (Integer neighbor : revAdj.get(node)) {
            if (visited[neighbor] == 0) {
                dfsK(neighbor, revAdj, visited);
            }
        }
    }
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
          int[] visited = new int[adj.size()];
          Stack<Integer> stack = new Stack<>();
          for(int i=0;i<adj.size();i++){
            if(visited[i] == 0){
                dfs(i,adj,visited,stack);
            }
          }
          List<List<Integer>> revAdj = new ArrayList<>();
          for(int i=0;i<adj.size();i++) revAdj.add(new ArrayList<>());
          for(int i=0;i<adj.size();i++){
            for(Integer it : adj.get(i)){
                revAdj.get(it).add(i);
            }
          }
          for(int i=0;i<visited.length;i++) visited[i] = 0;
          int sccCount = 0;
          while(!stack.isEmpty()){
            int node = stack.pop();
            if(visited[node] == 0){
                sccCount++;
                dfsK(node,revAdj,visited);
            }
          }
          return sccCount;
    }
}