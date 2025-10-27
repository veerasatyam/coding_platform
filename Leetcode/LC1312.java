// please refer the LongestPalindromic substring problem before doing this 
class Solution {
    public int minInsertions(String s) {
        return s.length() - longestPalindromeSubseq(s);
    }
     public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(s, 0, n - 1, dp);
    }
    private int helper(String text, int i, int j, int[][] dp) {
        if (i > j) return 0;
        if (i == j) return 1;

        if (dp[i][j] != -1) return dp[i][j];
        if (text.charAt(i) == text.charAt(j)) {
            dp[i][j] = 2 + helper(text, i + 1, j - 1, dp);
        } else {
            dp[i][j] = Math.max(
                helper(text, i + 1, j, dp),
                helper(text, i, j - 1, dp)
            );
        }

        return dp[i][j];
    }
}