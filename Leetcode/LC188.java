// please check the solution of LC123 before this 

class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][k+1];
        for(int[][] rows : dp){
            for(int row[] : rows) Arrays.fill(row,-1);
        }
        return helper(prices, 0, 1,k,dp);

    }
     private int helper(int[] prices,int i,int buy,int cap,int[][][] dp){
        if(cap==0) return 0;
        if(i==prices.length) return 0;
        if(dp[i][buy][cap] !=-1) return dp[i][buy][cap];
        int profit=0;
        if(buy==1) profit = Math.max(-prices[i] + helper(prices, i + 1, 0,cap,dp),helper(prices, i + 1, 1,cap,dp));
        else profit = Math.max(prices[i]+helper(prices,i+1,1,cap-1,dp),helper(prices,i+1,0,cap,dp));
        return dp[i][buy][cap]=profit;
    }
}



// Another approach 

// pure recursion 
class Solution {
    public int maxProfit(int k, int[] prices) {
        return helper(prices,0,0,k,prices.length);
    }
    private int helper(int[] prices,int i,int transNO,int k,int n){
        if(i==n || transNO==2*k) return 0;
        if(transNO%2==0){
            return Math.max(-prices[i]+helper(prices,i+1,transNO+1,k,n),helper(prices,i+1,transNO,k,n));
        }
        return Math.max(prices[i]+helper(prices,i+1,transNO+1,k,n),helper(prices,i+1,transNO,k,n));
    }
}


// memoization 
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2*k];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(prices, 0, 0, k, n, dp);
    }

    private int helper(int[] prices, int i, int transNO, int k, int n, int[][] dp) {
        if (i == n || transNO == 2*k) return 0;
        if (dp[i][transNO] != -1) return dp[i][transNO];

        int ans;
        if (transNO % 2 == 0) {
            ans = Math.max(-prices[i] + helper(prices, i+1, transNO+1, k, n, dp),
                           helper(prices, i+1, transNO, k, n, dp));
        } else {
            ans = Math.max(prices[i] + helper(prices, i+1, transNO+1, k, n, dp),
                           helper(prices, i+1, transNO, k, n, dp));
        }

        return dp[i][transNO] = ans;
    }
}
 
// tabulation 
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        // for large k values.
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
            }
            return profit;
        }
        int[][] dp = new int[n + 1][2 * k + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int transNO = 2 * k - 1; transNO >= 0; transNO--) {
             if (transNO % 2 == 0)dp[i][transNO] = Math.max(-prices[i] + dp[i + 1][transNO + 1],dp[i + 1][transNO]);
             else dp[i][transNO] = Math.max(prices[i] + dp[i + 1][transNO + 1],dp[i + 1][transNO]);
            }
        }
        return dp[0][0];
    }
}
