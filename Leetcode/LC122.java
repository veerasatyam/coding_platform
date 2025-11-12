class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        }
        return profit;
    }
}
 
// pure recursion
class Solution {
    public int maxProfit(int[] prices) {
       return helper(prices,0,1);
    }
    private int helper(int[] prices,int i,int buy){
        if(i==prices.length) return 0;
        int profit=0;
        if(buy==1) profit = Math.max(-prices[i] + helper(prices, i + 1, 0),helper(prices, i + 1, 1));
        else profit = Math.max(prices[i]+helper(prices,i+1,1),helper(prices,i+1,0));
        return profit;
    }
}

// recursion + memoiation 

class Solution {
    public int maxProfit(int[] prices) {
       int[][] dp = new int[prices.length][2];
       for(int[] row : dp) Arrays.fill(row,-1);    
       return helper(prices,0,1,dp);
    }
    private int helper(int[] prices,int i,int buy,int[][] dp){
        if(i==prices.length) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        int profit=0;
        if(buy==1) profit = Math.max(-prices[i] + helper(prices, i + 1, 0,dp),
                              helper(prices, i + 1, 1,dp));
        else profit = Math.max(prices[i]+helper(prices,i+1,1,dp),helper(prices,i+1,0,dp));
        return dp[i][buy]=profit;
    }
}


//tabulation

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[n][0] = dp[n][1] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit;
                if (buy == 1) profit = Math.max(-prices[i] + dp[i + 1][0],dp[i + 1][1]);
                else profit = Math.max(prices[i] + dp[i + 1][1],dp[i + 1][0]);
                dp[i][buy] = profit;
            }
        }
        return dp[0][1];
    }
}




//space optimisation


class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] ahead = new int[2];
        int[] cur = new int[2];
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit;
                if (buy == 1)
                    profit = Math.max(-prices[i] + ahead[0], ahead[1]);
                else
                    profit = Math.max(prices[i] + ahead[1], ahead[0]);
                cur[buy] = profit;
            }
            ahead[0] = cur[0];
            ahead[1] = cur[1];
        }
        return ahead[1];
    }
}

// further space optimisation..

class Solution {
    public int maxProfit(int[] prices) {
        int aheadBuy = 0, aheadSell = 0;  // dp[i+1][1] and dp[i+1][0]
        for (int i = prices.length - 1; i >= 0; i--) {
            int curBuy = Math.max(-prices[i] + aheadSell, aheadBuy);
            int curSell = Math.max(prices[i] + aheadBuy, aheadSell);
            aheadBuy = curBuy;
            aheadSell = curSell;
        }
        return aheadBuy;
    }
}
