// Bellman–Ford relaxes all edges repeatedly, so it works even with negative edge weights, can detect negative cycles, and handles constraints like limited edges or stops, but it is slower with time complexity O(VE). Dijkstra is a greedy algorithm that is much faster O(E log V) but only works correctly when all edge weights are non-negative and cannot detect negative cycles.



class Solution {
    public int[] bellmanFord(int V,int[][] edges,int src) {
        int INF=100000000;
        int[] dist=new int[V];
        Arrays.fill(dist,INF);
        dist[src]=0;
        for(int i=0;i<V-1;i++){
            for(int[] e:edges){
                int u=e[0],v=e[1],wt=e[2];
                if(dist[u]!=INF&&dist[u]+wt<dist[v]){
                    dist[v]=dist[u]+wt;
                }
            }
        }
        for(int[] e:edges){
            int u=e[0],v=e[1],wt=e[2];
            if(dist[u]!=INF&&dist[u]+wt<dist[v]){
                return new int[]{-1};
            }
        }
        return dist;
    }
}
