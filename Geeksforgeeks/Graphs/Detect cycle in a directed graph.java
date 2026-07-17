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


// another solution for dfs solution
class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V;i++) adj.add(new ArrayList<>());
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
        }
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        for(int i = 0;i < V;i++){
            if(!visited[i]){
                if(dfs(adj,i,visited,pathVisited)) return true;
            }
        }
        return false;
    }
    private static boolean dfs(List<List<Integer>> adj,int node,boolean[] visited,boolean[] pathVisited){
        pathVisited[node] = true;
        visited[node] = true;
        for(int x : adj.get(node)){
            if(!visited[x]){
                if(dfs(adj,x,visited,pathVisited)) return true;
            }else if(pathVisited[x]) return true;
        }
        pathVisited[node] = false;
        return false;
    }
}


// using toposort
class Solution{
    public boolean isCyclic(int V,int[][] edges){
        int[] inDegree=new int[V];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
            inDegree[e[1]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i]==0) q.add(i);
        }
        int count=0;
        while(!q.isEmpty()){
            int node=q.poll();
            count++;
            for(int it:adj.get(node)){
                inDegree[it]--;
                if(inDegree[it]==0) q.add(it);
            }
        }
        return count!=V;
    }
}
