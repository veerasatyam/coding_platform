class Solution {
    public boolean containsCycle(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (!visited[i][j]){
                    if (dfs(grid,visited,i,j,-1,-1)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid,boolean[][] visited,int r,int c,int pr,int pc) {
        visited[r][c] = true;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        for (int k = 0;k<4;k++){
            int nr = r + dr[k],nc = c + dc[k];
            if (nr<0||nc<0 || nr>=grid.length || nc>=grid[0].length)
                continue;
            if (grid[nr][nc] != grid[r][c]) continue;
            if (nr == pr && nc == pc) continue;
            if (visited[nr][nc]) return true;
            if (dfs(grid, visited, nr, nc, r, c)) return true;
        }
        return false;
    }
}


// same but a slifhtly different version
class Solution {
    public boolean containsCycle(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] visited = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0)
                if(dfsCheckCycle(grid,i,j,visited,-1,-1)) return true;
            }
        }
        return false;
    }
    private boolean dfsCheckCycle(char[][] grid,int r,int c,int[][] visited,int pr,int pc){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length) return false;
        if(visited[r][c]==1) return true;           
        if(visited[r][c]==2) return false;
        visited[r][c]=1;
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nRow=r+delRow[i];
            int nCol=c+delCol[i];
            if(nRow==pr && nCol==pc) continue;
            if(nRow>=0 && nCol>=0 && nRow<grid.length && nCol<grid[0].length && grid[nRow][nCol]==grid[r][c]){
                if(dfsCheckCycle(grid,nRow,nCol,visited,r,c)) return true;
            }
        }
        visited[r][c]=2;
        return false;
    }
}