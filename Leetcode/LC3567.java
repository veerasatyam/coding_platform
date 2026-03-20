class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] result = new int[n-k+1][m-k+1];
        for(int i = 0;i<n-k+1;i++){
            for(int j = 0;j<m-k+1;j++){
                result[i][j] = getMinAbsDiff(grid, i, j, k);
            }
        }
        return result;
    }
    private int getMinAbsDiff(int[][] grid,int x,int y,int k){
        int[] values = new int[k*k];
        int idx = 0;
        for(int i=x;i<x+k;i++){
            for(int j=y;j<y+k;j++){
                values[idx++] = grid[i][j];
            }
        }
        Arrays.sort(values);
        int minDiff = Integer.MAX_VALUE;
        for(int i=1;i<values.length;i++){
            if(values[i] != values[i-1]) minDiff = Math.min(minDiff, Math.abs(values[i] - values[i-1]));
        }
        return minDiff == Integer.MAX_VALUE ? 0 : minDiff;
    }
}