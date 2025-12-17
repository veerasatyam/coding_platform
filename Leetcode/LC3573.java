// pure recursion
class Solution {
    public long maximumProfit(int[] prices, int p) {
        return helper(prices,0,0,p);
    }
    private long helper(int[] prices,int index,int state,int k) {
        if (index == prices.length) {
            return (state == 0) ? 0:Integer.MIN_VALUE;
        }
        if (k == 0 && state != 0) {
            return Integer.MIN_VALUE;
        }
        long profit;
        if (state == 0) {
            profit = Math.max(Math.max(-prices[index] + helper(prices, index + 1, 1, k),prices[index] + helper(prices, index + 1, 2, k)),helper(prices, index + 1, 0, k));
        }
        else if (state == 1) {
            profit = Math.max(prices[index] + helper(prices, index + 1, 0, k - 1),helper(prices, index + 1, 1, k));
        }
        else {
            profit = Math.max(-prices[index] + helper(prices, index + 1, 0, k - 1),helper(prices, index + 1, 2, k));
        }
        return profit;
    }
}

// memoiation
class Solution {
    public long maximumProfit(int[] prices, int p) {
        int[][][] dp = new int[prices.length][3][p + 1];
        for (int[][] row : dp) {
            for (int[] r : row) {
                Arrays.fill(r,-1);
            }
        }
        return helper(prices,0,0,p,dp);
    }

    private long helper(int[] prices,int index,int state,int k,int[][][] dp) {
        if (index == prices.length) {
            return (state == 0) ? 0 : Integer.MIN_VALUE;
        }
        if (k ==0 && state!=0) {
            return Integer.MIN_VALUE;
        }
        if (dp[index][state][k] != -1) {
            return dp[index][state][k];
        }
        long profit;
        if (state==0){
            profit = Math.max(
                Math.max(
                    -prices[index] + helper(prices,index+1,1,k,dp),
                     prices[index] + helper(prices,index+1,2,k,dp)
                ),
                helper(prices,index+1,0,k,dp)
            );
        } else if (state == 1) {
            profit = Math.max(prices[index] + helper(prices,index+1,0,k-1,dp),
                helper(prices,index+1,1,k,dp));
        } else {
            profit = Math.max(-prices[index] + helper(prices,index+1,0,k-1,dp),
                helper(prices,index+1,2,k,dp));
        }
        dp[index][state][k] =(int)profit;
        return profit;
    }
}
