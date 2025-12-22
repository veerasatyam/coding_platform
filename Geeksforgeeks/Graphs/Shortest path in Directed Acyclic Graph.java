class Solution{
    class Pair{
        int first,second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int[] shortestPath(int V,int E,int[][] e){
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int i=0;i<E;i++){
            int u=e[i][0],v=e[i][1],wt=e[i][2];
            adj.get(u).add(new Pair(v,wt));
        }
        int[] vis=new int[V];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i]==0) topoSort(i,adj,vis,stack);
        }
        int[] dis=new int[V];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0]=0;
        while(!stack.isEmpty()){
            int node=stack.pop();
            if(dis[node]!=Integer.MAX_VALUE){
                for(Pair p:adj.get(node)){
                    if(dis[node]+p.second<dis[p.first]){
                        dis[p.first]=dis[node]+p.second;
                    }
                }
            }
        }
        for(int i=0;i<V;i++){
            if(dis[i]==Integer.MAX_VALUE) dis[i]=-1;
        }
        return dis;
    }
    private void topoSort(int node,List<List<Pair>> adj,int[] vis,Stack<Integer> stack){
        vis[node]=1;
        for(Pair p:adj.get(node)){
            if(vis[p.first]==0) topoSort(p.first,adj,vis,stack);
        }
        stack.push(node);
    }
}
