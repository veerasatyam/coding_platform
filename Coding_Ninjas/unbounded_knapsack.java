//pure recursion
public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        return helper(profit, weight, n - 1, w);
    }
    private static int helper(int[] profit, int[] weight, int index, int w) {
        if (index == 0) {
            return (w / weight[0]) * profit[0];
        }
        int notTake = helper(profit, weight, index - 1, w);
        int take = 0;
        if (weight[index] <= w)
            take = profit[index] + helper(profit, weight, index, w - weight[index]);
        return Math.max(take, notTake);
    }
}

// recursion + memoization

import java.util.*;
public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int dp[][] = new int[n][w+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return helper(profit, weight, n - 1, w,dp);
    }

    private static int helper(int[] profit, int[] weight, int index, int w,int[][] dp) {
        if (index == 0) {
            return (w / weight[0]) * profit[0];
        }
        if(dp[index][w]!=-1) return dp[index][w];
        int notTake = helper(profit, weight, index - 1, w,dp);
        int take = 0;
        if (weight[index] <= w)
            take = profit[index] + helper(profit, weight, index, w - weight[index],dp);
        dp[index][w] = Math.max(take,notTake);
        return dp[index][w];
    }
}



//tabulation

public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w + 1];
        for (int j = weight[0]; j <= w; j++) dp[0][j] = (j / weight[0]) * profit[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                int notTake = dp[i - 1][j];
                int take = 0;
                if (weight[i] <= j)
                    take = profit[i] + dp[i][j - weight[i]];
                dp[i][j] = Math.max(take, notTake);
            }
        }
        return dp[n - 1][w];
    }
}

