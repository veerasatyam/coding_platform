//pure recursion
class Solution {
    public int change(int amount, int[] coins) {
        return helper(coins, amount, coins.length - 1);
    }

    private int helper(int[] coins, int amount, int index) {
        if (index == 0) {
            if (amount % coins[0] == 0) return 1;
            return 0;
        }

        int notTake = helper(coins, amount, index - 1);
        int take = 0;
        if (coins[index] <= amount) {
            take = helper(coins, amount - coins[index], index);
        }

        return notTake + take;
    }
}

// recursion + memoization
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return helper(coins, amount, coins.length - 1,dp);
    }

    private int helper(int[] coins, int amount, int index,int[][] dp) {
        if (index == 0) {
            if (amount % coins[0] == 0) return 1;
            return 0;
        }
        if(dp[index][amount]!=-1) return dp[index][amount];
        int notTake = helper(coins, amount, index - 1,dp);
        int take = 0;
        if (coins[index] <= amount) {
            take = helper(coins, amount - coins[index], index,dp);
        }
        dp[index][amount] = notTake + take;
        return dp[index][amount];
    }
}

// tabulation 

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0) dp[0][t] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= amount; t++) {
                int notTake = dp[i - 1][t];
                int take = 0;
                if (coins[i] <= t) take = dp[i][t - coins[i]];
                dp[i][t] = notTake + take;
            }
        }

        return dp[n - 1][amount];
    }
}



//space optimization
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}
