class Solution {
    class Pairs{
        int distance,row,column;
        Pairs(int distance,int row,int column){
            this.distance = distance;
            this.row = row;
            this.column = column;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length,m = heights[0].length;
        int[][] dist = new int[n][m];
        for(int[] row : dist) Arrays.fill(row,Integer.MAX_VALUE);
        dist[0][0] = 0;
        PriorityQueue<Pairs> pq = new PriorityQueue<>((a,b)->a.distance-b.distance);
        pq.add(new Pairs(0,0,0));
        int[] directionsRow = {-1,0,+1,0};
        int[] directionsCol = {0,+1,0,-1};
        while(!pq.isEmpty()){
            Pairs x = pq.poll();
            int d = x.distance;
            int r = x.row;
            int c = x.column;
            if(r==n-1 && c==m-1) return d;
            for(int k=0;k<4;k++){
                int nr = r + directionsRow[k];
                int nc = c + directionsCol[k];
                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    int effort = Math.max(Math.abs(heights[r][c]-heights[nr][nc]),d);
                    if(dist[nr][nc] > effort){
                        dist[nr][nc] = effort;
                        pq.add(new Pairs(effort,nr,nc));
                    }
                }
            }
        }
        return 0;
    }
}