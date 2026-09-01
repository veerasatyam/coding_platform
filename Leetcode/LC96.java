// pure recursion, time complexity is O(2^n), space complexity is O(n)
class Solution {
    public int numTrees(int n) {
        return helper(n);
    }
    public int helper(int n) {
        if (n <= 1) {
            return 1;
        }
        int count = 0;
        for (int root = 1; root <= n; root++) {
            count += helper(root - 1) * helper(n - root);
        }
        return count;
    }
}



// recursion with memoization, time complexity is O(n^2), space complexity is O(n)
class Solution {
    public int numTrees(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return helper(n, memo);
    }
    public int helper(int n, int[] memo) {
        if (n <= 1) {
            return 1;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        int count = 0;
        for (int root = 1; root <= n; root++) {
            count += helper(root - 1, memo) * helper(n - root, memo);
        }
        memo[n] = count;
        return count;
    }
}



// dynamic programming, Tabulation Appraoch, time complexity is O(n^2), space complexity is O(n)
class Solution{
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int root = 1; root <= i; root++) {
                dp[i] += dp[root - 1] * dp[i - root];
            }
        }
        return dp[n];
    }
}