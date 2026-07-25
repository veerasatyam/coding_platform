// pure recursion
class Solution {
    public int minPathSum(int[][] grid) {
        return helper(0,0,grid);
    }
    private int helper(int i,int j,int[][] grid) {
            if (i >= grid.length || j >= grid[0].length) return Integer.MAX_VALUE;
            if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
            int right = helper(i,j + 1,grid);
            int down = helper(i + 1,j,grid);
            int min = Math.min(right,down);
            if (min == Integer.MAX_VALUE) return min;
            return grid[i][j] + min;
        }
}

// recursion + memoization
class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] row : dp) Arrays.fill(row,-1);
        return helper(0,0,grid,dp);
    }
    private int helper(int i,int j,int[][] grid,int[][] dp) {
            if (i >= grid.length || j >= grid[0].length) return Integer.MAX_VALUE;
            if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
            if(dp[i][j] != -1) return dp[i][j];
            int right = helper(i,j + 1,grid,dp);
            int down = helper(i + 1,j,grid,dp);
            int min = Math.min(right,down);
            if (min == Integer.MAX_VALUE) return min;
            return dp[i][j] = grid[i][j] + min;
        }
}

// tabulation
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        int sum = 0;
        for (int i = 0;i < n;i++) {
            dp[i][0] = grid[i][0] + sum;
            sum += grid[i][0];
        }
        sum = 0;
        for (int i = 0;i < m;i++) {
            dp[0][i] = grid[0][i] + sum;
            sum += grid[0][i];
        }
        for (int i = 1;i < n;i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n - 1][m - 1];
    }
}
