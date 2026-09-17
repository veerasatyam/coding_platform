class Solution {
    static final int MOD = 1_000_000_007;
    public int numberOfSets(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        return (int) helper(n, k, 0,dp);
    }
    private long helper(int n, int k, int start,int[][] dp) {
        if (k == 0) {
            return 1;
        }
        if (start >= n - 1) {
            return 0;
        }
        if(dp[start][k] != -1) return dp[start][k];
        long ans = 0;
        for (int i = start; i < n - 1; i++){
            for (int j = i + 1; j < n; j++) {
                ans += helper(n, k - 1, j,dp);
                ans %= MOD;
            }
        }
        return dp[start][k] = (int) ans;
    }
}



// tabulation
class Solution {
    static final int MOD = 1_000_000_007;
    public int numberOfSets(int n, int K) {
        int [][] dp = new int[K + 1][n + 1];
        for(int i = 0; i <= n - 1; i++) dp[0][i] = 1;
        for(int  k = 1; k <= K; k++){
            for(int i = n - 1; i >= 0; i--){
                int take = 0;
                for(int j = i + 1; j <= n - 1; j++){
                    take += dp[k - 1][j];
                    take %= MOD;
                }
                int skip = dp[k][i + 1] % mod;
                dp[k][i] = (take + skip) % MOD;
            }
        }
        return dp[K][0];
    }
}

// further optimized tabulation
class Solution {
    static final int MOD = 1_000_000_007;
    public int numberOfSets(int n, int K) {
        int [][] dp = new int[K + 1][n + 1];
        for(int i = 0; i <= n - 1; i++) dp[0][i] = 1;
        for(int  k = 1; k <= K; k++){
            int[] prevRowSum = new int[n + 1];
            for(int x = n - 1; x >= 0; x--){
                prevRowSum[x] = (prevRowSum[x + 1] + dp[k - 1][x]) % MOD;
            }
            for(int i = n - 1; i >= 0; i--){
                int take = prevRowSum[i + 1];
                int skip = dp[k][i + 1] % MOD;
                dp[k][i] = (take + skip) % MOD;
            }
            
        }
        return dp[K][0];
    }
}