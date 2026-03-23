class Solution {
    public int maxProductPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        long[][] maxProduct = new long[n][m];
        long[][] minProduct = new long[n][m];
        maxProduct[0][0] = minProduct[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            maxProduct[i][0] = minProduct[i][0] = maxProduct[i - 1][0] * grid[i][0];
        }
        for (int j = 1; j < m; j++) {
            maxProduct[0][j] = minProduct[0][j] = maxProduct[0][j - 1] * grid[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                long x = grid[i][j];
                long a = maxProduct[i - 1][j] * x;
                long b = maxProduct[i][j - 1] * x;
                long c = minProduct[i - 1][j] * x;
                long d = minProduct[i][j - 1] * x;
                maxProduct[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                minProduct[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }
        if(maxProduct[n - 1][m - 1] < 0) {
            return -1;
        }
        return (int)(maxProduct[n - 1][m - 1] % 1000000007);
    }
}