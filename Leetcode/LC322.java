//pure recursion 
class Solution {
    public int coinChange(int[] coins, int amount) {
        int res = helper(coins, coins.length - 1, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    private int helper(int[] coins, int index, int amount) {
        if (amount == 0) return 0;
        if (index == 0) {
            if (amount % coins[0] == 0) return amount / coins[0];
            return Integer.MAX_VALUE;
        }
        int notTake = helper(coins, index - 1, amount);
        int take = Integer.MAX_VALUE;
        if (coins[index] <= amount) {
            take =1+ helper(coins, index, amount - coins[index]);
        }
        return Math.min(take, notTake);
    }
}

//recusion + memorization
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for (int[] row : dp) Arrays.fill(row, -1);
        int res = helper(coins, coins.length - 1, amount,dp);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    private int helper(int[] coins, int index, int amount,int[][] dp) {
        if (amount == 0) return 0;
        if (index == 0) {
            if (amount % coins[0] == 0) return amount / coins[0];
            return Integer.MAX_VALUE;
        }
        if(dp[index][amount]!=-1) return dp[index][amount];
        int notTake = helper(coins, index - 1, amount,dp);
        int take = Integer.MAX_VALUE;
        if (coins[index] <= amount) {
            take =1+ helper(coins, index, amount - coins[index],dp);
        }
        dp[index][amount] = Math.min(take,notTake);
        return dp[index][amount];
    }
}

// tabulation

import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        int INF = Integer.MAX_VALUE - 1; 
        for (int a = 0; a <= amount; a++) {
            if (a % coins[0] == 0) dp[0][a] = a / coins[0];
            else dp[0][a] = INF;
        }
        for (int i = 1; i < n; i++) {
            for (int a = 0; a <= amount; a++) {
                int notTake = dp[i - 1][a];
                int take = INF;
                if (coins[i] <= a) take = 1 + dp[i][a - coins[i]];
                dp[i][a] = Math.min(take, notTake);
            }
        }
        return dp[n - 1][amount] >= INF ? -1 : dp[n - 1][amount];
    }
}

//space optimisation..
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
