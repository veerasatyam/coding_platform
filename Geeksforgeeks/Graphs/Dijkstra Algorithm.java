// using Priority Queue

class Solution{
    class Pairs{
        int dist,node;
        Pairs(int dist,int node){
            this.dist=dist;
            this.node=node;
        }
    }
    public int[] dijkstra(int V,int[][] edges,int src){
        List<List<Pairs>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        for(int[] e:edges){
            adj.get(e[0]).add(new Pairs(e[2],e[1]));
            adj.get(e[1]).add(new Pairs(e[2],e[0]));
        }
        PriorityQueue<Pairs> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
        int[] distance=new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src]=0;
        pq.add(new Pairs(0,src));
        while(!pq.isEmpty()){
            Pairs p=pq.poll();
            int node=p.node,dis=p.dist;
            if(dis>distance[node])continue;
            for(Pairs x:adj.get(node)){
                if(distance[x.node]>dis+x.dist){
                    distance[x.node]=dis+x.dist;
                    pq.add(new Pairs(distance[x.node],x.node));
                }
            }
        }
        return distance;
    }
}
