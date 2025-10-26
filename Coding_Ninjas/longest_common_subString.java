// Refer longestCommonSubsequence before doing this 


public class Solution {
    public static int lcs(String str1, String str2) {
        return helper(str1, str2, 0, 0, 0);
    }
    private static int helper(String s1, String s2, int i, int j, int count) {
        if (i == s1.length() || j == s2.length()) {
            return count;
        }
        int c1 = count;
        if (s1.charAt(i) == s2.charAt(j)) {
            c1 = helper(s1, s2, i + 1, j + 1, count + 1);
        }
        int c2 = helper(s1, s2, i + 1, j, 0);
        int c3 = helper(s1, s2, i, j + 1, 0);

        return Math.max(c1, Math.max(c2, c3));
    }
}

//memoization // not that imp understand the core logic for below tabulation 
public class Solution {
    public static int longestCommonSubstring(String str1, String str2) {
        int[][][] dp = new int[str1.length()][str2.length()][str1.length()+1];
        for(int[][] arr2: dp) for(int[] arr1: arr2) Arrays.fill(arr1, -1);
        return helper(str1, str2, 0, 0, 0, dp);
    }
    private static int helper(String s1, String s2, int i, int j, int count, int[][][] dp) {
        if(i == s1.length() || j == s2.length()) return count;
        if(dp[i][j][count] != -1) return dp[i][j][count];
        int c1 = count;
        if(s1.charAt(i) == s2.charAt(j)) {
            c1 = helper(s1, s2, i+1, j+1, count+1, dp);
        }
        int c2 = helper(s1, s2, i+1, j, 0, dp);
        int c3 = helper(s1, s2, i, j+1, 0, dp);
        dp[i][j][count] = Math.max(c1, Math.max(c2, c3));
        return dp[i][j][count];
    }
}

// tabulation 
public class Solution {
    public static int longestCommonSubstring(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m+1][n+1];
        int maxLen = 0;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen;
    }
}
