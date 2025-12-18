class Solution{
    public List<Integer> eventualSafeNodes(int[][] graph){
        int v=graph.length;
        int[] visited=new int[v];
        int[] pathVisited=new int[v];
        int[] check=new int[v];
        for(int i=0;i<v;i++){
            if(visited[i]==0){
                dfs(graph,visited,pathVisited,i,check);
            }
        }
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<v;i++) if(check[i]==1) res.add(i);
        return res;
    }
    private boolean dfs(int[][] graph,int[] visited,int[] pathVisited,int i,int[] check){
        visited[i]=1;
        pathVisited[i]=1;
        for(int x:graph[i]){
            if(visited[x]==0){
                if(dfs(graph,visited,pathVisited,x,check)){
                    check[i]=0;
                    return true;
                }
            }else if(pathVisited[x]==1){
                check[i]=0;
                return true;
            }
        }
        pathVisited[i]=0;
        check[i]=1;
        return false;
    }
}
