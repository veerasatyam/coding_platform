// pure recursion
class Solution {
    public int minCost(int n, int[] cuts) {
        int[] C = new int[cuts.length + 2];
        C[0] = 0;
        C[C.length - 1] = n;
        Arrays.sort(cuts);
        for (int i = 1; i < C.length - 1; i++) C[i] = cuts[i - 1];
        return solve(C, 0, C.length - 1);
    }

    private int solve(int[] C, int i, int j) {
        if (j - i <= 1) return 0;
        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int cost = (C[j] - C[i]) + solve(C, i, k) + solve(C, k, j);
            min = Math.min(min, cost);
        }
        return min;
    }
}


// recursion + memoiation 
class Solution {
    public int minCost(int n, int[] cuts) {
        int[] C = new int[cuts.length + 2];
        C[0] = 0;
        C[C.length - 1] = n;
        Arrays.sort(cuts);
        for (int i = 1; i < C.length - 1; i++) C[i] = cuts[i - 1];
        int[][] dp = new int[C.length][C.length];
        for(int[] row : dp) Arrays.fill(row,-1);
        return solve(C, 0, C.length - 1,dp);
    }

    private int solve(int[] C, int i, int j,int[][] dp) {
        if (j - i <= 1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int cost = (C[j] - C[i]) + solve(C, i, k, dp) + solve(C, k, j, dp);
            min = Math.min(min, cost);
        }
        return dp[i][j]=min;
    }
}


// tabulation 

class Solution {
    public int minCost(int n, int[] cuts) {
        int[] C = new int[cuts.length + 2];
        C[0] = 0;
        C[C.length - 1] = n;
        Arrays.sort(cuts);
        for (int i = 1; i < C.length - 1; i++) C[i] = cuts[i - 1];
        int m = C.length;
        int[][] dp = new int[m][m];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = i + 1; j < m; j++) {
                if (j - i <= 1) { 
                    dp[i][j] = 0;
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int cost = (C[j] - C[i]) + dp[i][k] + dp[k][j];
                    min = Math.min(min, cost);
                }
                dp[i][j] = min;
            }
        }
        return dp[0][m - 1];
    }
}
