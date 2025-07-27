import java.util.Arrays;

class Solution {
    static int[][] dp;

    static int knapSack(int val[], int wt[], int capacity) {
        int n = val.length;
        dp = new int[n][capacity + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(n - 1, val, wt, capacity);
    }

    static int solve(int i, int[] val, int[] wt, int cap) {
        if (i == 0) {
            if (wt[0] <= cap)
                return val[0] + solve(0, val, wt, cap - wt[0]);
            else
                return 0;
        }

        if (dp[i][cap] != -1) return dp[i][cap];

        int notTake = solve(i - 1, val, wt, cap);
        int take = 0;
        if (wt[i] <= cap) {
            take = val[i] + solve(i, val, wt, cap - wt[i]);
        }

        return dp[i][cap] = Math.max(take, notTake);
    }
}
