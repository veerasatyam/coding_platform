class Solution {
    class Cell{
        int i,j,distance;
        Cell(int i,int j,int distance){
            this.i = i;
            this.j = j;
            this.distance = distance;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0]==1 || grid[n-1][m-1]==1) return -1;
        boolean[][] visited = new boolean[n][m];
        Queue<Cell> q = new LinkedList<>();
        q.add(new Cell(0,0,1));
        visited[0][0] = true;
        int[] directionsRow = {-1,-1,-1,0,0,1,1,1};
        int[] directionsCol = {-1,0,1,-1,1,-1,0,1};
        while(!q.isEmpty()){
            Cell x = q.poll();
            int row = x.i;
            int col = x.j;
            int dis = x.distance;
            if (row == n-1 && col == m-1) return dis;
            for (int k = 0; k < 8; k++) {
                int nr = row + directionsRow[k];
                int nc = col + directionsCol[k];
                if (nr>=0 && nc>=0 && nr<n && nc<m && !visited[nr][nc] && grid[nr][nc]==0){
                    visited[nr][nc]=true;
                    q.add(new Cell(nr,nc,dis+1));
                }
            }
        }
        return -1;
    }
}