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

// using bfs and toposort
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adjRev = new ArrayList<>();
        for(int i=0;i<graph.length;i++) adjRev.add(new ArrayList<>());
        int[] inDegree = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            for(int a : graph[i]){
                adjRev.get(a).add(i);
                inDegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(inDegree[i]==0) q.add(i);
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for(int a : adjRev.get(node)){
                inDegree[a]--;
                if(inDegree[a]==0) q.add(a);
            }
        }
        Collections.sort(res);
        return res;
       
    }
}