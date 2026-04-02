// pure recursion
class Solution {
    int max = Integer.MIN_VALUE;
    public int maximumAmount(int[][] coins) {
        helper(0,0,0,coins,0);
        return max;
    }
    private void helper(int i,int j,int k,int[][] coins,int sum) {
        if (i >= coins.length || j >= coins[0].length) return;
        int val = coins[i][j];
        if (i == coins.length-1 && j==coins[0].length - 1) {
            max = Math.max(max,sum + val);
            if (val<0 && k<2)max = Math.max(max, sum);
            return;
        }
        if(val >= 0){
            helper(i + 1,j,k,coins,sum + val);
            helper(i,j+1,k,coins,sum + val);
        }else{
            helper(i + 1,j,k,coins,sum + val);
            helper(i,j+1,k,coins,sum + val);
            if(k < 2){
                helper(i + 1,j,k+1,coins,sum);
                helper(i,j+1,k+1,coins,sum);
            }
        }
    }
}

// same recursion with slight modification for implementing memoization
class Solution {
    public int maximumAmount(int[][] coins) {
        return helper(0,0,0,coins);
    }

    private int helper(int i,int j,int k,int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;
        if (i >= n || j >= m) return Integer.MIN_VALUE;
        int val = coins[i][j];
        if (i == n - 1 && j == m - 1) {
            if (val < 0 && k < 2) return 0;
            return val;
        }
        int down = helper(i + 1, j, k, coins);
        int right = helper(i, j + 1, k, coins);
        int bestNext = Math.max(down,right);
        int take = Integer.MIN_VALUE;

        if (bestNext != Integer.MIN_VALUE) {
            take = val + bestNext;
        }
        int skip = Integer.MIN_VALUE;
        if (val < 0 && k < 2){
            int downSkip = helper(i + 1,j,k + 1,coins);
            int rightSkip = helper(i,j + 1,k + 1,coins);
            skip = Math.max(downSkip, rightSkip);
        }
        return Math.max(take,skip);
    }
}


// recursion + memoization 
class Solution {
    public int maximumAmount(int[][] coins) {
        int[][][] dp = new int[coins.length + 1][coins[0].length + 1][3];
        for(int[][] arr : dp){
            for(int[] row : arr) Arrays.fill(row,Integer.MIN_VALUE);
        }
        return helper(0,0,0,coins,dp);
    }

    private int helper(int i,int j,int k,int[][] coins,int[][][] dp) {
        int n = coins.length;
        int m = coins[0].length;
        if (i >= n || j >= m) return Integer.MIN_VALUE;
        if(dp[i][j][k] != Integer.MIN_VALUE) return dp[i][j][k];
        int val = coins[i][j];
        if (i == n - 1 && j == m - 1) {
            if (val < 0 && k < 2) return dp[i][j][k] = 0;
            return dp[i][j][k] = val;
        }

        int down = helper(i + 1, j, k, coins,dp);
        int right = helper(i, j + 1, k, coins,dp);
        int bestNext = Math.max(down,right);

        int take = Integer.MIN_VALUE;
        if (bestNext != Integer.MIN_VALUE) {
            take = val + bestNext;
        }
        int skip = Integer.MIN_VALUE;
        if (val < 0 && k < 2){
            int downSkip = helper(i + 1,j,k + 1,coins,dp);
            int rightSkip = helper(i,j + 1,k + 1,coins,dp);
            skip = Math.max(downSkip, rightSkip);
        }
        return dp[i][j][k] = Math.max(take,skip);
    }
}


// tabulation

class Solution {
    public int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;
        int[][][] dp = new int[n + 1][m + 1][3];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                for(int k = 0; k < 3; k++){
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        for(int k = 0;k<3;k++){
             int val = coins[n-1][m-1];
             if(val < 0 && k < 2) dp[n-1][m-1][k] = 0;
             else dp[n-1][m-1][k] = val;
        }

        for(int i = n-1;i>=0;i--){
            for(int j = m-1;j>=0;j--){
                if(i == n-1 && j == m-1) continue;
                for(int k = 0;k<3;k++){
                    int val = coins[i][j];
                    int down = dp[i + 1][j][k];
                    int right = dp[i][j + 1][k];
                    int bestNext = Math.max(down, right);

                    int take = Integer.MIN_VALUE;
                    if(bestNext != Integer.MIN_VALUE){
                        take = val + bestNext;
                    }

                    int skip = Integer.MIN_VALUE;
                    if(val < 0 && k < 2){
                        int downSkip = dp[i + 1][j][k + 1];
                        int rightSkip = dp[i][j + 1][k + 1];
                        skip = Math.max(downSkip, rightSkip);
                    }

                    dp[i][j][k] = Math.max(take, skip);
                }
            }
        }
        return dp[0][0][0];
    }
}