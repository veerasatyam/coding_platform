class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        int n=grid.length,m=<grid[0].length;
        for(int i=0;i<n;i++) grid[i][0]+=grid[i-1][0];
        for(int i=0;i<m;i++) grid[0][i]+=grid[0][i-1];
        for(int i=1;i<n;i++){
            for(int j=1;j<m;i++){
                grid[i][j] += grid[i-1][j]+grid[i][j-1];
                max = Math.max(max,grid[i][j]);
            }
        }
        return max;
    }
}