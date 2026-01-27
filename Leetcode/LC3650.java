class Solution {
    class Pairs{
        int node;
        int dist;
        Pairs(int dist,int node){
            this.node = node;
            this.dist = dist;
        }
    }
    public int minCost(int n, int[][] edges) {
        List<List<Pairs>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] e : edges){
            adj.get(e[0]).add(new Pairs(e[2],e[1]));
            adj.get(e[1]).add(new Pairs(2*e[2],e[0]));
        }
        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        PriorityQueue<Pairs> pq = new PriorityQueue<>((a,b)->a.dist - b.dist);
        pq.add(new Pairs(0,0));
        distance[0] = 0;
        while(!pq.isEmpty()){
            Pairs x = pq.poll();
            int nd = x.node;
            int d = x.dist;
            for(Pairs it : adj.get(nd)){
                if(distance[it.node] > d + it.dist){
                    distance[it.node] = d + it.dist;
                    pq.add(new Pairs(distance[it.node],it.node));
                }
            }
        }
        return distance[n-1]==Integer.MAX_VALUE ? -1 : distance[n-1];
    }
}