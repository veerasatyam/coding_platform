// pure recursion
class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        return helper(s,t,n-1,m-1);
    }
    private int helper(String s,String t,int i,int j){
        if(j<0) return 1;
        if(i<0) return 0;
        if(s.charAt(i)==t.charAt(j)){
            return helper(s,t,i-1,j-1) + helper(s,t,i-1,j);
        }else{
            return helper(s,t,i-1,j);
        }
    }
}


// Recursion + memoization
class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row,-1);
        return helper(s,t,n-1,m-1,dp);
    }
    private int helper(String s,String t,int i,int j,int[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=helper(s,t,i-1,j-1,dp) + helper(s,t,i-1,j,dp);
        }else{
            return dp[i][j] = helper(s,t,i-1,j,dp);
        }
    }
}

//tabulation

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) dp[i][0] = 1; 
        for (int j = 1; j <= m; j++) dp[0][j] = 0; 
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][m];
    }
}


//space optimization 

import java.util.*;

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];
        prev[0] = curr[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + prev[j];
                } else {
                    curr[j] = prev[j];
                }
            }
            prev = curr.clone();
        }
        return prev[m];
    }
}
