//pure recursion

class Solution {
    public int numSquares(int n) {
        return helper(n);
    }

    private int helper(int n) {
        if (n == 0) return 0;
        int minCount = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            int count = 1 + helper(n - square);
            minCount = Math.min(minCount, count);
        }
        return minCount;
    }
}



//recursion + memoization
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }

    private int helper(int n, int[] dp) {
        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];
        int minCount = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            minCount = Math.min(minCount, 1 + helper(n - square, dp));
        }
        return dp[n] = minCount;
    }
}



import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
