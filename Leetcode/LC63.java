import java.util.Arrays;

class Solution {
    int[][] dp;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        return ways(m - 1, n - 1, obstacleGrid);
    }

    int ways(int i, int j, int[][] mat) {
        if (i < 0 || j < 0) return 0;
        if (mat[i][j] == 1) return 0;
        if (i == 0 && j == 0) return 1;

        if (dp[i][j] != -1) return dp[i][j];

        dp[i][j] = ways(i - 1, j, mat) + ways(i, j - 1, mat);
        return dp[i][j];
    }
}
