class Solution {
    int cntOnes(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0;i<n;i++) if(grid[i][0] == 1) dfs(i,0,grid);
        for(int i = 0;i<n;i++) if(grid[i][m-1] == 1) dfs(i,m-1,grid);
        for(int j = 0;j<m;j++) if(grid[0][j] == 1) dfs(0,j,grid);
        for(int j = 0;j<m;j++) if(grid[n-1][j] == 1) dfs(n-1,j,grid);
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1) count++;
            }
        }
    }
    void dfs(int i,int j,int[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 0) return;
        grid[i][j] = 0;
        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
    }
}