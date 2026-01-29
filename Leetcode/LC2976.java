// using Dijkstra's algorithm to find the minimum cost to convert each character
class Solution {
    class Pair {
        int node;
        long cost;
        Pair(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            adj.get(u).add(new Pair(v, cost[i]));
        }
        long[][] dist = new long[26][26];
        for (int i=0;i<26;i++) Arrays.fill(dist[i],Long.MAX_VALUE);
        for (int i=0;i<26;i++) {
            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));
            dist[i][i] = 0;
            pq.add(new Pair(i, 0));
            while (!pq.isEmpty()) {
                Pair cur = pq.poll();
                int node = cur.node;
                long cst = cur.cost;
                if (cst > dist[i][node]) continue;
                for (Pair nei : adj.get(node)) {
                    if (cst + nei.cost < dist[i][nei.node]) {
                        dist[i][nei.node] = cst + nei.cost;
                        pq.add(new Pair(nei.node, dist[i][nei.node]));
                    }
                }
            }
        }
        long total = 0;
        for (int i=0;i<source.length();i++) {
            int s = source.charAt(i)-'a';
            int t = target.charAt(i)-'a';
            if (s == t) continue;
            if (dist[s][t]==Long.MAX_VALUE) return -1;
            total += dist[s][t];
        }
        return total;
    }
}


// using Floyd-Warshall algorithm to find the minimum cost to convert each character
class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] dis = new int[26][26];
        for(int i = 0 ; i < 26 ;i++){
            Arrays.fill(dis[i] , Integer.MAX_VALUE);
            dis[i][i] = 0 ;
        }
        for(int i = 0 ; i < cost.length ; i++){
            dis[original[i] - 'a'][changed[i] - 'a'] = Math.min(dis[original[i] - 'a'][changed[i] - 'a'],cost[i]);
        }
        for(int k = 0 ; k < 26 ; k++){
            for(int i = 0 ; i < 26 ; i++){
                if(dis[i][k] < Integer.MAX_VALUE){
                    for(int j = 0 ; j < 26 ; j++){
                        if(dis[k][j] < Integer.MAX_VALUE){
                            dis[i][j] = Math.min(dis[i][j] , dis[i][k] + dis[k][j]);
                        }
                    }
                }
            }
        }
        long ans = 0L ;
        for(int i = 0 ; i <source.length() ;i++){
            int c1 = source.charAt(i) - 'a';
            int c2 = target.charAt(i) - 'a';
            if(dis[c1][c2] == Integer.MAX_VALUE){
                return -1L;
            }
            ans += (long)dis[c1][c2];
        }

        return ans ;
    }
}