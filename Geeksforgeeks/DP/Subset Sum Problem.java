import java.util.Arrays;

class Solution {
    static int[][] dp;

    static boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        dp = new int[n][sum + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return subset(n - 1, sum, arr) == 1;
    }

    static int subset(int i, int sum, int[] arr) {
        if (sum == 0) return 1;
        if (i < 0) return 0;

        if (dp[i][sum] != -1) return dp[i][sum];

        int notTake = subset(i - 1, sum, arr);
        int take = 0;
        if (arr[i] <= sum) {
            take = subset(i - 1, sum - arr[i], arr);
        }

        dp[i][sum] = notTake | take;
        return dp[i][sum];
    }
}
