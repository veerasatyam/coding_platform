class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        helper(0, visited, adj, result);
        return result;
    }
    
    private void helper(int node,boolean[] visited,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> result){
        visited[node] = true;
        result.add(node);
        for (int neig : adj.get(node)) {
            if (!visited[neig]) helper(neig,visited,adj,result);
        }
    }
}