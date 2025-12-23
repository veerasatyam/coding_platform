// using bfs
class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] dis = new int[V];
        Arrays.fill(dis,Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dis[src] = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            for(int a : adj.get(node)){
                if(dis[a]>dis[node] + 1){
                    dis[a] = dis[node] + 1;
                    q.add(a);
                }
            }
        }
        for(int i=0;i<V;i++) if(dis[i]==Integer.MAX_VALUE) dis[i] = -1;
        return dis;
    }
}