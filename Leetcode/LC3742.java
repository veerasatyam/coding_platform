// pure recursion
class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int res = helper(grid.length - 1, grid[0].length - 1, grid, k);
        return res == Integer.MIN_VALUE ? -1 : res;
    }

    private int helper(int i, int j, int[][] grid, int k) {
        if (i < 0 || j < 0) return Integer.MIN_VALUE;
        int cost = (grid[i][j] == 0) ? 0 : 1;
        int score = grid[i][j];
        if (k < cost) return Integer.MIN_VALUE;
        if (i == 0 && j == 0) {
            return score;
        }
        int left = helper(i, j - 1, grid, k - cost);
        int up = helper(i - 1, j, grid, k - cost);
        int max = Integer.MIN_VALUE;
        if (left != Integer.MIN_VALUE) {
            max = Math.max(max, score + left);
        }
        if (up != Integer.MIN_VALUE) {
            max = Math.max(max, score + up);
        }
        return max;
    }
}


// recursion + memoiation

class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int[][][] dp = new int[grid.length+1][grid[0].length+1][k+1];
        for(int[][] mat : dp){
            for(int[] row : mat) Arrays.fill(row,-1);
        }
        int res = helper(grid.length - 1, grid[0].length - 1, grid, k, dp);
        return res == Integer.MIN_VALUE ? -1 : res;
    }

    private int helper(int i, int j, int[][] grid, int k, int[][][] dp) {
        if (i < 0 || j < 0) return Integer.MIN_VALUE;
        if(dp[i][j][k] != -1) return dp[i][j][k];
        int cost = (grid[i][j] == 0) ? 0 : 1;
        int score = grid[i][j];
        if (k < cost) return Integer.MIN_VALUE;
        if (i == 0 && j == 0) {
            return score;
        }
        int left = helper(i, j - 1, grid, k - cost,dp);
        int up = helper(i - 1, j, grid, k - cost,dp);
        int max = Integer.MIN_VALUE;
        if (left != Integer.MIN_VALUE) {
            max = Math.max(max, score + left);
        }
        if (up != Integer.MIN_VALUE) {
            max = Math.max(max, score + up);
        }
        return dp[i][j][k] = max;
    }
}



// tabulation 
