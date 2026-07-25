// recursion
class Solution {
    public int superEggDrop(int k, int n) {
        return eggDrop(k,n);
    }
    private int eggDrop(int k,int n){
        if(k == 1) return n;
        if(n == 0 || n == 1) return n;
        int min = Integer.MAX_VALUE;
        for(int x = 1;x <= n; x++){
            int eggBreaks = eggDrop(k - 1,x - 1);
            int eggSurvives = eggDrop(k,n - x);
            int temp = 1 + Math.max(eggBreaks, eggSurvives);
            min = Math.min(min,temp);
        }
        return min;
    }
}


// recursion + memoization
class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return eggDrop(k,n,dp);
    }
    private int eggDrop(int k,int n,int[][] dp){
        if(k == 1) return n;
        if(n == 0 || n == 1) return n;
        if(dp[k][n] != -1) return dp[k][n];
        int min = Integer.MAX_VALUE;
        for(int x = 1;x <= n; x++){
            int eggBreaks = eggDrop(k - 1,x - 1,dp);
            int eggSurvives = eggDrop(k,n - x,dp);
            int temp = 1 + Math.max(eggBreaks, eggSurvives);
            min = Math.min(min,temp);
        }
        return dp[k][n] = min;
    }
}

// tabulation
class Solution{
    public int superEggDrop(int k,int n){
        int[][] dp = new int[k + 1][n + 1];
        for(int i = 1;i <= k;i++){
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        for(int j = 1;j <= n;j++){
            dp[1][j] = j;
        }
        for(int i = 2;i <= k;i++){
            for(int j = 2;j <= n;j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int x = 1;x <= j;x++){
                    int eggBreaks = dp[i - 1][x - 1];
                    int eggSurvives = dp[i][j - x];
                    int temp = 1 + Math.max(eggBreaks,eggSurvives);
                    dp[i][j] = Math.min(dp[i][j],temp);
                }
            }
        }
        return dp[k][n];
    }
}



// 