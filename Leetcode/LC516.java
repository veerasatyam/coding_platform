// recusion using the Longest subsequence logic
class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder str2 = new StringBuilder(s).reverse();
        int n = s.length();
        return helper(s, str2.toString(), n - 1, n - 1);
    }

    private int helper(String text1, String text2, int i, int j) {
        if (i < 0 || j < 0) return 0;

        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + helper(text1, text2, i - 1, j - 1);
        } else {
            return Math.max(
                helper(text1, text2, i - 1, j),
                helper(text1, text2, i, j - 1)
            );
        }
    }
}

// Recursion 
class Solution {
    public int longestPalindromeSubseq(String s) {
        return helper(s, 0, s.length() - 1);
    }

    private int helper(String text, int i, int j) {
        if (i > j) return 0;
        if (i == j) return 1;

        if (text.charAt(i) == text.charAt(j)) {
            return 2 + helper(text, i + 1, j - 1);
        } else {
            return Math.max(
                helper(text, i + 1, j),
                helper(text, i, j - 1)
            );
        }
    }
}

// recursion + memoization

import java.util.Arrays;

class Solution {
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
