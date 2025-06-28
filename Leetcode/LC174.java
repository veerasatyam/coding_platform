class Solution {
    int[][] dp;

    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        dp = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                dp[i][j] = -1;

        return minH(0, 0, dungeon);
    }

    int minH(int i, int j, int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;

        if (i >= n || j >= m) return Integer.MAX_VALUE;

        if (i == n - 1 && j == m - 1) {
            return Math.max(1 - dungeon[i][j], 1);
        }
        if (dp[i][j] != -1) return dp[i][j];
        int down = minH(i + 1, j, dungeon);
        int right = minH(i, j + 1, dungeon);
        int minNext = Math.min(down, right);
        dp[i][j] = Math.max(minNext - dungeon[i][j], 1);

        return dp[i][j];
    }
}
