import java.util.* ;
import java.io.*; 
// pure recursion
public class Solution {
    public static int countPartitions(int n, int d, int[] arr) {
        int sum = 0;
        for (int num : arr) sum += num;
        if ((sum + d) % 2 != 0 || sum < d) return 0;
        int target = (sum + d) / 2;
        return helper(arr, n - 1, target);
    }

    private static int helper(int[] arr, int index, int target) {
        if (index == 0) {
            if (target == 0 && arr[0] == 0) return 2;
            if (target == 0 || target == arr[0]) return 1;
            return 0;
        }
        int notTake = helper(arr, index - 1, target);
        int take = 0;
        if (arr[index] <= target) take = helper(arr, index - 1, target - arr[index]);
        return take + notTake;
    }
}

// recursion + memorization

public class Solution {
    public static int countPartitions(int n, int d, int[] arr) {
        int sum = 0;
        for (int num : arr) sum += num;
        if ((sum - d) % 2 != 0 || sum < d) return 0;
        int target = (sum - d) / 2;
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1);         
        return helper(arr, n - 1, target, dp);
    }

    private static int helper(int[] arr, int index, int target, int[][] dp) {
        if (index == 0) {
            if (target == 0 && arr[0] == 0) return 2;
            if (target == 0 || target == arr[0]) return 1;
            return 0;
        }
        if (dp[index][target] != -1) return dp[index][target];
        int notTake = helper(arr, index - 1, target, dp);
        int take = 0;
        if (arr[index] <= target) take = helper(arr, index - 1, target - arr[index], dp);
        return dp[index][target] = take + notTake;
    }
}


//tabulation

import java.util.*;

public class Solution {
    public static int countPartitions(int n, int d, int[] arr) {
        int mod = 1_000_000_007;
        int sum = 0;
        for (int num : arr) sum += num;
        if (sum < d || (sum - d) % 2 != 0) return 0;
        int target = (sum - d) / 2;
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                int notTake = dp[i - 1][j];
                int take = 0;
                if (arr[i - 1] <= j) take = dp[i - 1][j - arr[i - 1]];
                dp[i][j] = (take + notTake) % mod;
            }
        }
        return dp[n][target];
    }
}
