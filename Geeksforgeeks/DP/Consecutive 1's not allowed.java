// pure recursion
class Solution {
    int countStrings(int n) {
        return helper(0,n);
    }
    private int helper(int i,int n){
        if(i>=n) return 1;
        int take = helper(i+2,n);
        int NotTake = helper(i+1,n);
        return take + NotTake;
   }
}

// memoiation + recursion

class Solution {
    int countStrings(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(0,n,dp);
    }
    private int helper(int i,int n,int[] dp){
        if(i>=n) return 1;
        if(dp[i] != -1) return dp[i];
        int take = helper(i+2,n,dp);
        int NotTake = helper(i+1,n,dp);
        return dp[i] = take + NotTake;
    }
}


// tabulation
class Solution {
    int countStrings(int n) {
        int[] dp = new int[n+2];
        dp[n+1] = dp[n] = 1;
        for(int i = n-1;i>=0;i--){
            int take = dp[i+2];
            int NotTake = dp[i+1];
            dp[i] = take + NotTake;
        }
        return dp[0];
    }
}


// spaceoptimisation 
class Solution {
    int countStrings(int n) {
       int a = 1, b = 1;
        for(int i = n-1;i>=0;i--){
            int take = b;
            int NotTake = a;
            b = a;
            a = take + NotTake;
        }
        return a;
    }
}