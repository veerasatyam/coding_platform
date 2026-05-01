// pure recursion
class Solution {
    public int longCommSubstr(String s1, String s2) {
        return helper(0,0,s1,s2,0);
    }
    private int helper(int i,int j,String s1,String s2,int count){
        if(i == s1.length() || j == s2.length()) return count;
        int temp = count;
        if(s1.charAt(i) == s2.charAt(j)){
            temp = helper(i+1,j+1,s1,s2,count + 1);
        }
        else{
            int t1 = helper(i+1,j,s1,s2,0);
            int t2 = helper(i,j+1,s1,s2,0);
            temp = Math.max(temp,Math.max(t1,t2));
        }
        return temp;
    }
}

// recursion + memoization 
// this approach will result memory limit exceed
class Solution {
    public int longCommSubstr(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][][] dp = new int[n + 1][m + 1][Math.min(n, m) + 1];
        for(int[][] mat : dp) {
            for(int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }
        return helper(0, 0, s1, s2, 0, dp);
    }

    private int helper(int i, int j,String s1,String s2,int count,int[][][] dp) {
        if(i == s1.length() || j == s2.length()) {
            return count;
        }
        if(dp[i][j][count] != -1) return dp[i][j][count];
        int ans = count;
        if(s1.charAt(i) == s2.charAt(j)) {
            ans = Math.max(ans, helper(i + 1, j + 1, s1, s2, count + 1, dp));
        }
        ans = Math.max(ans, helper(i + 1,j,s1,s2,0,dp));
        ans = Math.max(ans, helper(i,j + 1,s1,s2,0,dp));
        return dp[i][j][count] = ans;
    }
}

class Solution{
    int[][] dp;
    public int longCommSubstr(String s1,String s2){
        dp = new int[s1.length()][s2.length()];
        for(int[] row : dp) Arrays.fill(row,-1);
        return lcs(0,0,s1,s2,0,dp);
    }
    private int lcs(int i,int j,String s1,String s2,int count,int[][] dp){
        if(i == s1.length() || j == s2.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = lcs(i+1,j+1,s1,s2,count + 1,dp);
        int t1 = lcs(i+1,j,s1,s2,0,dp);
        int t2 = lcs(i,j+1,s1,s2,0,dp);
        return Math.max(dp[i][j],Math.max(t1,t2));
    }
}