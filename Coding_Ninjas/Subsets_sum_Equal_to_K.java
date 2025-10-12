import java.util.*;
//Pure Recursion
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]) {
        return helper(n - 1, k, arr);
    }

    private static boolean helper(int index, int target, int[] arr) {
        if (target == 0) return true;
        if (index == 0) return target == arr[0];
        boolean notTake = helper(index - 1, target, arr);
        boolean take = false;
        if (target >= arr[index]) {
            take = helper(index - 1, target - arr[index], arr);
        }
        return take || notTake;
    }
}

//Recursion + Memorization 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]) {
        int[][] dp = new int[n][k + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return helper(n - 1, k, arr, dp);
    }

    private static boolean helper(int index, int target, int[] arr, int[][] dp) {
        if (target == 0) return true;
        if (index == 0) return target == arr[0];
        if (dp[index][target] != -1) return dp[index][target] == 1;
        boolean notTake = helper(index - 1, target, arr, dp);
        boolean take = false;
        if (target >= arr[index]) {
            take = helper(index - 1, target - arr[index], arr, dp);
        }
        dp[index][target] = (take || notTake) ? 1 : 0;
        return take || notTake;
    }
}

//tabulation 

import java.util.*;

public class Solution {
    public static boolean subsetSumToK(int n, int k, int[] arr) {
        boolean[][] dp = new boolean[n][k + 1];
        for (int i = 0; i < n; i++)
            dp[i][0] = true;

        if (arr[0] <= k)
            dp[0][arr[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= k; target++) {
                boolean notTake = dp[i - 1][target];
                boolean take = false;
                if (target >= arr[i])
                    take = dp[i - 1][target - arr[i]];

                dp[i][target] = take || notTake;
            }
        }

        return dp[n - 1][k];
    }
}


