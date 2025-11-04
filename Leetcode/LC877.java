//pure recusion 
class Solution {
    public boolean stoneGame(int[] piles) {
        return helper(piles, 0, piles.length - 1) > 0;
    }

    private int helper(int[] piles, int i, int j) {
        if (i == j) return piles[i];
        int takeLeft = piles[i] - helper(piles, i + 1, j);
        int takeRight = piles[j] - helper(piles, i, j - 1);
        return Math.max(takeLeft, takeRight);
    }
}

// recursion + memoization 
class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Integer[][] memo = new Integer[n][n];
        return helper(piles, 0, n - 1, memo) > 0;
    }

    private int helper(int[] piles, int i, int j, Integer[][] memo) {
        if (i == j) return piles[i];
        if (memo[i][j] != null) return memo[i][j];

        int takeLeft = piles[i] - helper(piles, i + 1, j, memo);
        int takeRight = piles[j] - helper(piles, i, j - 1, memo);

        memo[i][j] = Math.max(takeLeft, takeRight);
        return memo[i][j];
    }
}

//tabulation
class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) dp[i][i] = piles[i];
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        
        return dp[0][n - 1] > 0;
    }
}
