// pure recursion
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        return helper(0,0,s1,s2);
    }
    private int helper(int i,int j,String s1,String s2){
        if(i==s1.length() || j==s2.length()){
            int sum=0;
            for(int k=i;k<s1.length();k++) sum+=s1.charAt(k);
            for(int k=j;k<s2.length();k++) sum+=s2.charAt(k);
            return sum;
        }
        if(s1.charAt(i)==s2.charAt(j)) return helper(i+1,j+1,s1,s2);
        return Math.min(s1.charAt(i)+helper(i+1,j,s1,s2),s2.charAt(j)+helper(i,j+1,s1,s2));
    }
}

// memoization
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for(int[] row : dp) Arrays.fill(row,-1);
        return helper(0,0,s1,s2,dp);
    }
    private int helper(int i,int j,String s1,String s2,int[][] dp){
        if(i==s1.length() || j==s2.length()){
            int sum=0;
            for(int k=i;k<s1.length();k++) sum+=s1.charAt(k);
            for(int k=j;k<s2.length();k++) sum+=s2.charAt(k);
            return sum;
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return helper(i+1,j+1,s1,s2,dp);
        return dp[i][j] = Math.min(s1.charAt(i)+helper(i+1,j,s1,s2,dp),s2.charAt(j)+helper(i,j+1,s1,s2,dp));
    }
}


// tabulation

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length() , m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for (int j = m - 1; j >= 0; j--) dp[n][j] = dp[n][j + 1] + s2.charAt(j);
        for (int i = n - 1; i >= 0; i--) dp[i][m] = dp[i + 1][m] + s1.charAt(i);
        for(int i = n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.min(s1.charAt(i)+dp[i+1][j],s2.charAt(j)+dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}