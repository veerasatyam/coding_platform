class Solution {
    class pairs {
        int np;
        int from;
        int to;
        pairs(int np,int from,int to){
            this.np = np;
            this.from = from;
            this.to = to;
        }
    }
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<pairs> pq = new PriorityQueue<>((a,b) -> a.from - b.from);
        PriorityQueue<pairs> drop = new PriorityQueue<>((a,b) -> a.to - b.to);

        for(int[] trip : trips) pq.add(new pairs(trip[0],trip[1],trip[2]));

        int curr = 0;
        while(!pq.isEmpty()){
            pairs x = pq.poll();
            while(!drop.isEmpty() && drop.peek().to <= x.from){
                curr -= drop.poll().np;
            }
            curr += x.np;
            if(curr > capacity) return false;
            drop.add(x);
        }
        return true;
    }
}


// optimal solution
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] road = new int[1001];
        for(int[] trip : trips){
            int np = trip[0];
            int from = trip[1];
            int to = trip[2];
            road[from] += np;
            road[to] -= np;
        }
        int res = 0;
        for(int i = 0;i<=1000;i++){
            res += road[i];
            if(res > capacity) return false;
        }
        return res == 0;
    }
}
