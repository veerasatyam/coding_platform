//  pure recursion
class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s, p, s.length() - 1, p.length() - 1);
    }

    private boolean helper(String s, String p, int i, int j) {
        if (i < 0 && j < 0) return true;
        if (j < 0) return false;
        if (i < 0) {
            for (int x = j; x >= 0; x--) 
                if (p.charAt(x) != '*') return false;
            return true;
        }
        if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') return helper(s, p, i - 1, j - 1);
        if (p.charAt(j) == '*') return helper(s, p, i - 1, j) || helper(s, p, i, j - 1);
        return false;
    }
}


//recursion + memoization 

class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(s, p, s.length() - 1, p.length() - 1, dp);
    }

    private boolean helper(String s, String p, int i, int j, int[][] dp) {
        if (i < 0 && j < 0) return true;
        if (j < 0) return false;
        if (i < 0) {
            for (int x = j; x >= 0; x--) if (p.charAt(x) != '*') return false;
            return true;
        }
        if (dp[i][j] != -1) return dp[i][j] == 1;
        boolean ans;
        if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') {
            ans = helper(s, p, i - 1, j - 1, dp);
        } else if (p.charAt(j) == '*') {
            ans = helper(s, p, i - 1, j, dp) || helper(s, p, i, j - 1, dp);
        } else {
            ans = false;
        }
        dp[i][j] = ans ? 1 : 0;
        return ans;
    }
}



// tabulation


class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        
        dp[0][0] = true;
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 1];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (pc == sc || pc == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }
}
