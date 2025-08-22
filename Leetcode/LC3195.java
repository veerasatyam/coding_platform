class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length,m=grid[0].length;
        int x1 = n,y1=m;
        int x2 = 0,y2=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    x1 = Math.min(x1,i);
                    x2 = Math.max(x2,i);
                    y1 = Math.min(y1,j);
                    y2 = Math.max(y2,j);
                }
            }
        }
        return (x2-x1+1)*(y2-y1+1);
    }
}