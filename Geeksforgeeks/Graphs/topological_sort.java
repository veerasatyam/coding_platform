// also called as khans algorithm..
// used only for directed Acyclic graphs
class Solution {
    public ArrayList<Integer> topoSort(int V,int[][] edges){
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] e:edges) adj.get(e[0]).add(e[1]);
        boolean[] visited=new boolean[V];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<V;i++)
            if(!visited[i]) dfs(i,adj,visited,stack);
        ArrayList<Integer> res=new ArrayList<>();
        while(!stack.isEmpty()) res.add(stack.pop());
        return res;
    }
    private void dfs(int u,List<List<Integer>> adj,boolean[] visited,Stack<Integer> stack){
        visited[u]=true;
        for(int v:adj.get(u))
            if(!visited[v]) dfs(v,adj,visited,stack);
        stack.push(u);
    }
}

// using dfs

class solution{
    public ArrayList<Integer> topoSort(int V,int[][] edges){
        int inDegree[] = new int[V];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] e:edges) adj.get(e[0]).add(e[1]);
        for(int i=0;i<V;i++){
            for(int it : adj.get(i)) inDegree[it]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i]==0) q.add(i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            res.add(node);
            for(int it : adj.get(node)){
                inDegree[it]--;
                if(inDegree[it]==0) q.add(it);
            }
        }
        return res; 
    }
}