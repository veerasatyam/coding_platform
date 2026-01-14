// you can use dfs or bfs for the Solution

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i=0;i<n;i++) {
            if (!visited[i]) {
                count++;
                dfs(i,isConnected,visited);
            }
        }
        return count;
    }
    private void dfs(int node,int[][] graph,boolean[] visited) {
        visited[node] = true;
        for (int j = 0;j<graph.length;j++) {
            if (graph[node][j] == 1 && !visited[j]) {
                dfs(j,graph,visited);
            }
        }
    }
}



// using disjoint set
// you can use dfs or bfs for the Solution
class DisjoinSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjoinSet(int n){
        for(int i=0;i<=n;i++){
            size.add(1);
            parent.add(i);
        }
    }
    public int findParent(int node){
        if(node==parent.get(node)) return node;
        int ulp = findParent(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void unionBySize(int u,int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u==ulp_v) return;
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_v) + size.get(ulp_u));
        }else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        DisjoinSet ds = new DisjoinSet(isConnected.length);
        int n = isConnected.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 1) ds.unionBySize(i,j);
            }
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(ds.findParent(i)==i) count++;
        }
        return count;
    }
}
