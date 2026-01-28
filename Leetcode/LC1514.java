class Solution {
    class Pairs{
        int node;
        double prob;
        Pairs(int node, double prob){
            this.node=node;
            this.prob=prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pairs>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            double p=succProb[i];
            adj.get(u).add(new Pairs(v,p));
            adj.get(v).add(new Pairs(u,p));
        }
        PriorityQueue<Pairs> pq = new PriorityQueue<>((a,b)->b.prob > a.prob ? 1 : -1);
        double[] probs = new double[n];
        probs[start_node]=1.0;
        pq.add(new Pairs(start_node,1.0));
        while(!pq.isEmpty()){
            Pairs p = pq.poll();
            int node = p.node;
            dounble prob = p.prob;
            if(node == end_node) return prob;
            for(Pairs next : adj.get(node)){
                double newProb = prob * next.prob;
                if(newProb > probs[next.node]){
                    probs[next.node] = newProb;
                    pq.add(new Pairs(next.node, newProb));
                }
            }
        }
        return 0.0;
    }
}