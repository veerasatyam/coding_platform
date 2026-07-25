// recursion 
class Solution {
    static int[][] dp;
    static boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        return subset(n - 1, sum, arr) == 1;
    }
    static int subset(int i, int sum, int[] arr) {
        if (sum == 0) return 1;
        if (i < 0) return 0;
        int notTake = subset(i - 1, sum, arr);
        int take = 0;
        if (arr[i] <= sum) take = subset(i - 1, sum - arr[i], arr);
        return notTake | take;
    }
}



// recursion + memoization

class Solution {
    static int[][] dp;
    static boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        dp = new int[n][sum + 1];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return subset(n - 1, sum, arr) == 1;
    }
    static int subset(int i, int sum, int[] arr) {
        if (sum == 0) return 1;
        if (i < 0) return 0;
        if (dp[i][sum] != -1) return dp[i][sum];
        int notTake = subset(i - 1, sum, arr);
        int take = 0;
        if (arr[i] <= sum) take = subset(i - 1, sum - arr[i], arr);
        dp[i][sum] = notTake | take;
        return dp[i][sum];
    }
}

// tabulation
class Solution {
    static boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][sum + 1];
        for (int i = 0; i < n; i++) dp[i][0] = true;
        if (arr[0] <= sum) dp[0][arr[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                boolean notTake = dp[i - 1][j];
                boolean take = false;
                if (arr[i] <= j) take = dp[i - 1][j - arr[i]];
                dp[i][j] = notTake | take;
            }
        }
        return dp[n - 1][sum];
    }
}