class Solution {
    static class Pairs{
        int r,c,time;
        Pairs(int r,int c,int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        Queue<Pairs> q = new LinkedList<>();
        int countFresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    visited[i][j] = 2;
                    q.add(new Pairs(i,j,0));
                }else{
                    visited[i][j] = 0;
                }
                if(grid[i][j]==1) countFresh++;
            }
        }
        int time = 0;
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        int count = 0;
        int minTime = 0;
        while(!q.isEmpty()){
            Pairs x = q.remove();
            int r = x.r;
            int c = x.c;
            int t = x.time;
            minTime = Math.max(t,minTime);
            for(int i=0;i<4;i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow >=0 && nrow <n && ncol >= 0 && ncol < m 
                && visited[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    q.add(new Pairs(nrow,ncol,t+1));
                    visited[nrow][ncol] = 2;
                    count++;
                }
            }
       }
       if(count == countFresh) return minTime;
       return -1;
    }
}