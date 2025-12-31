class Solution {
    class Node{
        int node,cost;
        Node(int node,int cost){
            this.node = node;
            this.cost = cost;
        }
    }
    class Pairs{
        int s,n,c;
        Pairs(int s,int n,int c){
            this.s = s;
            this.n = n;
            this.c = c;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Node>> adj = new ArrayList<>(); 
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int m = flights.length;
        for(int i=0;i<m;i++){
            adj.get(flights[i][0]).add(new Node(flights[i][1],flights[i][2]));
        }
        Queue<Pairs> q = new LinkedList<>();
        q.add(new Pairs(0,src,0));
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        while(!q.isEmpty()){
            Pairs x = q.poll();
            int stops = x.s;
            int nd = x.n;
            int cost = x.c;
            if(stops>k) continue;
            for(Node a : adj.get(nd)){
                int adjNode = a.node;
                int edN = a.cost;
                if(cost + edN < dist[adjNode] && stops <= k){
                    dist[adjNode] = cost + edN;
                    q.add(new Pairs(stops+1,adjNode,cost+edN));
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}