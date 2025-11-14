// pure recursion 

class Solution {
    public int maxProfit(int[] prices) {
        return helper(prices, 0, 1,2);
    }
    private int helper(int[] prices,int i,int buy,int cap){
        if(cap==0) return 0;
        if(i==prices.length) return 0;
        int profit=0;
        if(buy==1) profit = Math.max(-prices[i] + helper(prices, i + 1, 0,cap),helper(prices, i + 1, 1,cap));
        else profit = Math.max(prices[i]+helper(prices,i+1,1,cap-1),helper(prices,i+1,0,cap));
        return profit;
    }
}


// memoization 
import java.util.Arrays;

class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for(int[][] rows : dp){
            for(int row[] : rows) Arrays.fill(row,-1);
        }
        return helper(prices, 0, 1,2,dp);
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


//tabulation

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];
        // // Base case 1: No transactions left
        // for (int i = 0; i <= n; i++) {
        //     for (int buy = 0; buy <= 1; buy++) {
        //         dp[i][buy][0] = 0;
        //     }
        // }
        // // Base case 2: Past the last day
        // for (int buy = 0; buy <= 1; buy++) {
        //     for (int cap = 0; cap <= 2; cap++) {
        //         dp[n][buy][cap] = 0;
        //     }
        // }
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (buy == 1)dp[i][buy][cap] = Math.max(-prices[i] + dp[i + 1][0][cap],dp[i + 1][1][cap]);
                    else dp[i][buy][cap] = Math.max(prices[i] + dp[i + 1][1][cap - 1],dp[i + 1][0][cap]);
                }
            }
        }
        return dp[0][1][2];
    }
}


//space optimisation....

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] ahead = new int[2][3];
        int[][] curr = new int[2][3];

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    int profit;
                    if (buy == 1) {
                        profit = Math.max(-prices[i] + ahead[0][cap],
                                          ahead[1][cap]);
                    } else {
                        profit = Math.max(prices[i] + ahead[1][cap - 1],
                                          ahead[0][cap]);
                    }
                    curr[buy][cap] = profit;
                }
            }
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 0; cap <= 2; cap++) {
                    ahead[buy][cap] = curr[buy][cap];
                }
            }
        }

        return ahead[1][2];
    }
}
