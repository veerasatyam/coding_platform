// pure recursion 
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return helper(text1,text2,text1.length()-1,text2.length()-1);
    }
    private int helper(String text1,String text2,int i,int j){
        if(i<0 || j<0) return 0;
        if(text1.charAt(i)==text2.charAt(j)) return 1 + helper(text1,text2,i-1,j-1);
        return Math.max(helper(text1,text2,i-1,j),helper(text1,text2,i,j-1));
    }
}

// recursion + memoization 
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] row : dp) Arrays.fill(row,-1);
        return helper(text1,text2,text1.length()-1,text2.length()-1,dp);
    }
    private int helper(String text1,String text2,int i,int j,int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(text1.charAt(i)==text2.charAt(j)){
            dp[i][j] = 1 + helper(text1,text2,i-1,j-1,dp);
            return dp[i][j];
        }
        dp[i][j] = Math.max(helper(text1,text2,i-1,j,dp),helper(text1,text2,i,j-1,dp));
        return dp[i][j];
    }
}

//tabulation 

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}


// space optimization 

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = curr.clone();
        }
        return prev[m];
    }
}
