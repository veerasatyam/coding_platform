import java.util.*;
class Solution{
    class Pair{
        long d;int n;
        Pair(long d,int n){this.d=d;this.n=n;}
    }
    static final int MOD=1_000_000_007;
    public int countPaths(int n,int[][] roads){
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int[] r:roads){
            adj.get(r[0]).add(new Pair(r[2],r[1]));
            adj.get(r[1]).add(new Pair(r[2],r[0]));
        }
        long[] dist=new long[n];
        int[] ways=new int[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;ways[0]=1;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Long.compare(a.d,b.d));
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair cur=pq.poll();
            if(cur.d>dist[cur.n])continue;
            for(Pair nxt:adj.get(cur.n)){
                long nd=cur.d+nxt.d;
                int v=nxt.n;
                if(nd<dist[v]){
                    dist[v]=nd;
                    ways[v]=ways[cur.n];
                    pq.add(new Pair(nd,v));
                }else if(nd==dist[v]){
                    ways[v]=(ways[v]+ways[cur.n])%MOD;
                }
            }
        }
        return ways[n-1];
    }
}
