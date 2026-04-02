// // pure recursion
// class Solution {
//     int countWays(int n, int k) {
//        return helper(0,-1,0,n,k);
//     }
//     private int helper(int i ,int prev,int prevCount,int n,int k){
//         if(prevCount > 2) return 0;
//         if(i >= n) return 1;
//         int count = 0;
//         for(int x = 0;x<k;x++){
//             if(x == prev) count += helper(i+1,x,prevCount+1,n,k);
//             else count += helper(i+1,x,1,n,k);
//         }
//         return count;
//     }
// }

// // memoization + recursion
// class Solution {
//     int countWays(int n, int k){
//         int[][][] dp = new int[n+1][k+1][3];
//         for(int[][] mat : dp){
//             for(int[] row : mat) Arrays.fill(row,-1);
//         }
//         return helper(0,-1,0,n,k,dp);
//     }

//     private int helper(int i ,int prev,int prevCount,int n,int k,int[][][] dp){
//         if(prevCount > 2) return 0;
//         if(i >= n) return 1;
//         if(dp[i][prev+1][prevCount] != -1)
//             return dp[i][prev+1][prevCount];
//         int count = 0;
//         for(int x = 0;x<k;x++){
//             if(x == prev) count += helper(i+1,x,prevCount+1,n,k,dp);
//             else count += helper(i+1,x,1,n,k,dp);
//         }
//         return dp[i][prev+1][prevCount] = count;
//     }
// }

//  The above two solution are the other approaches but it have more time complexity 

// Expected Approach 
class Solution {
    int countWays(int n, int k) {
        return helper(n,k);
    }
    private int helper(int n,int k){
        if(n==1) return k;
        if(n==2) return k*k;
        int count1 = helper(n-1,k)*(k-1);
        int count2 = helper(n-2,k)*(k-1);
        return count1 + count2;
    }
}
// memoization
class Solution {
    int countWays(int n, int k) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,k,dp);
    }
    private int helper(int n,int k,int[] dp){
        if(n==1) return k;
        if(n==2) return k*k;
        if(dp[n] != -1) return dp[n];
        int count1 = helper(n-1,k,dp)*(k-1);
        int count2 = helper(n-2,k,dp)*(k-1);
        return dp[n] = count1 + count2;
    }
}


// tabulation 
class Solution {
    int countWays(int n, int k) {
        if(n==1) return k;
        int[] dp = new int[n+1];
        dp[1] = k;
        dp[2] = k*k;
        for(int i=3;i<=n;i++){
            int count1 = dp[i-1]*(k-1);
            int count2 = dp[i-2]*(k-1);
            dp[i] = count1 + count2;
        }
        return dp[n];
    }
}

// space optimisation
class Solution {
    int countWays(int n, int k) {
        if(n==1) return k;
        int a = k;
        int b = k*k;
        for(int i=3;i<=n;i++){
            int count1 = b*(k-1);
            int count2 = a*(k-1);
            a = b;
            b = count1 + count2;
        }
        return b;
    }
}

