// using Recursion
// class Solution {
//     static int knapsack(int W, int val[], int wt[]) {
//         return solve(val.length - 1, val, wt, W);
//     }

//     static int solve(int i, int[] val, int[] wt, int k) {
//         if (i < 0 || k == 0) return 0;
//         int a = solve(i - 1, val, wt, k);
//         int b = 0;
//         if (k >= wt[i]) 
//             b = solve(i - 1, val, wt, k - wt[i]) + val[i];
//         return Math.max(a, b);
//     }
// }

// usind  Recursive DP

import java.util.Arrays;

class Solution {
    static int[][] dp;

    static int knapsack(int W, int val[], int wt[]) {
        dp = new int[val.length][W + 1];
        for (int i = 0; i < val.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(val.length - 1, val, wt, W);
    }

    static int solve(int i, int[] val, int[] wt, int k) {
        if (i < 0 || k == 0) return 0;

        if (dp[i][k] == -1) {
            int a = solve(i - 1, val, wt, k);
            int b = 0;
            if (k >= wt[i]) 
                b = solve(i - 1, val, wt, k - wt[i]) + val[i];

            dp[i][k] = Math.max(a, b);
        }

        return dp[i][k];
    }
}
