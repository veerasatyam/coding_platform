class Solution{
    public boolean isCyclic(int V,int[][] adj){
        boolean[] visited=new boolean[V];
        boolean[] pathVisited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]&&dfs(i,adj,visited,pathVisited))return true;
        }
        return false;
    }
    private boolean dfs(int node,int[][] adj,boolean[] visited,boolean[] pathVisited){
        visited[node]=true;
        pathVisited[node]=true;
        for(int a:adj[node]){
            if(!visited[a]){
                if(dfs(a,adj,visited,pathVisited))return true;
            }else if(pathVisited[a])return true;
        }
        pathVisited[node]=false;
        return false;
    }
}
