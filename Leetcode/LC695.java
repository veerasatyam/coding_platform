class Solution {
    public int maxAreaOfIsland(int[][] grid) {
       int maxA = 0;
       int n = grid.length,m=grid[0].length;
       for(int i=0;i<n;i++){
          for(int j=0;j<m;j++){
            if(grid[i][j]==1){
                int area = dfs(i,j,grid);
                maxA = Math.max(area,maxA); 
            }
          }
       }
       return maxA;
    }
    private int dfs(int i,int j,int[][] grid){
        if(i>=grid.length || j>= grid[0].length|| i<0 || j<0 || grid[i][j]!=1)  return 0;

        grid[i][j]=0;
        return 1+dfs(i-1,j,grid) + dfs(i+1,j,grid) + dfs(i,j-1,grid) + dfs(i,j+1,grid);
    }
}