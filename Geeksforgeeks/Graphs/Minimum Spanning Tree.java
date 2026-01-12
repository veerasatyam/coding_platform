// using prims algorithm
// O(E log V)
// key points: use priority queue to get min edge, use boolean array to track visited nodes
// add edges of newly visited node to priority queue
// continue until all nodes are visited
// graph is represented as adjacency list
// queue stores node weight
 class Solution {
    class Pair {
        int node, distance;
        public Pair(int distance, int node) {
            this.node = node;
            this.distance = distance;
        }
    }

    public int spanningTree(int V, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(new Pair(e[2], e[1]));
            adj.get(e[1]).add(new Pair(e[2], e[0]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        boolean[] visited = new boolean[V];
        pq.add(new Pair(0, 0));
        int total = 0;
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int node = cur.node;
            int dist = cur.distance;
            if (visited[node]) continue;
            visited[node] = true;
            total += dist;
            for (Pair nei : adj.get(node)) {
                if (!visited[nei.node]) {
                    pq.add(new Pair(nei.distance, nei.node));
                }
            }
        }
        return total;
    }
}


// using kruskals algorithm and disjoint set


class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n){
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
            size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
        }else{
            parent.set(ulp_v,ulp_u);    
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}

class Solution{
    public int spanningTree(int V,int[][] edges){
        DisjointSet ds = new DisjointSet(V);
        Arrays.sort(edges,(a,b)-> a[2]-b[2]);
        int total = 0;
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            if(ds.findParent(u) != ds.findParent(v)){
                ds.unionBySize(u,v);
                total += wt;
            }
        }
        return total;
    }
}