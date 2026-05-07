class Solution {
    public int minimumOperations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ops = 0;
        for (int j = 0;j<n;j++) {
            int prev = grid[0][j];
            for (int i = 1;i < m;i++){
                if (grid[i][j] <= prev) {
                    int needed = prev + 1;
                    ops += needed - grid[i][j];
                    prev = needed;
                } else {
                    prev = grid[i][j];
                }
            }
        }
        return ops;
    }
}