//Pure Recursion Time Complexity O(3^n * 3^n),and space would be O(n) Auxilary stack space

class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        return helper(0, 0, m - 1, grid, n, m);
    }

    private int helper(int i, int j1, int j2, int[][] grid, int n, int m) {
        if (j1 < 0 || j2 < 0 || j1 >= m || j2 >= m) return (int) -1e8;
        if (i == n - 1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        int max = Integer.MIN_VALUE;
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                int value;
                if (j1 == j2) value = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];
                value += helper(i + 1, j1 + d1, j2 + d2, grid, n, m);
                max = Math.max(max, value);
            }
        }
        return max;
    }
}


//Recursion + Memorization Time complexity O(N*M*M)x9 space O(n^3)+O(n)
class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][][] dp = new int[n][m][m];
        for (int[][] arr : dp)
            for (int[] row : arr)
                Arrays.fill(row, -1);
        return helper(0, 0, m - 1, grid, n, m,dp);
    }

    private int helper(int i, int j1, int j2, int[][] grid, int n, int m,int[][][] dp) {
        if (j1 < 0 || j2 < 0 || j1 >= m || j2 >= m) return (int) -1e8;
        if (i == n - 1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        int max = Integer.MIN_VALUE;
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                int value;
                if (j1 == j2) value = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];
                value += helper(i + 1, j1 + d1, j2 + d2, grid, n, m,dp);
                max = Math.max(max, value);
            }
        }
        dp[i][j1][j2] = max;
        return  dp[i][j1][j2];
    }
}
