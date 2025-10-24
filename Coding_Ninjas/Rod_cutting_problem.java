// pure recursion
public class Solution {
    public static int cutRod(int price[], int n) {
        return helper(price, n, n - 1);
    }
    private static int helper(int[] price, int n, int index) {
        if (index == 0) {
            return n * price[0];
        }
        int notTake = helper(price, n, index - 1);
        int take = Integer.MIN_VALUE;
        int rodLength = index + 1;
        if (n >= rodLength) {
            take = price[index] + helper(price, n - rodLength, index);
        }
        return Math.max(take, notTake);
    }
}


// recursion + memoization 
import java.util.*;
public class Solution {
    public static int cutRod(int price[], int n) {
        int dp[][] = new int[n][n+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return helper(price, n, n - 1,dp);
    }
    private static int helper(int[] price, int n, int index,int[][] dp) {
        if (index == 0) {
            return n * price[0];
        }
        if(dp[index][n]!=-1) return dp[index][n];
        int notTake = helper(price, n, index - 1);
        int take = Integer.MIN_VALUE;
        int rodLength = index + 1;
        if (n >= rodLength) {
            take = price[index] + helper(price, n - rodLength, index);
        }
        dp[index][n] = Math.max(take,notTake);
        return dp[index][n];
    }
}

//tabulation
import java.util.*;

public class Solution {
    public static int cutRod(int price[], int n) {
        int[][] dp = new int[n][n + 1];
        for (int len = 0; len <= n; len++) {
            dp[0][len] = len * price[0];
        }
        for (int index = 1; index < n; index++) {
            int rodLength = index + 1;
            for (int len = 0; len <= n; len++) {
                int notTake = dp[index - 1][len];
                int take = Integer.MIN_VALUE;
                if (len >= rodLength) {
                    take = price[index] + dp[index][len - rodLength];
                }
                dp[index][len] = Math.max(take, notTake);
            }
        }

        return dp[n - 1][n];
    }
}

//space optimization
public class Solution {
    public static int cutRod(int price[], int n) {
        int[] dp = new int[n + 1];
        for (int len = 0; len <= n; len++) {
            dp[len] = len * price[0];
        }
        for (int index = 1; index < n; index++) {
            int rodLength = index + 1;
            for (int len = rodLength; len <= n; len++) {
                dp[len] = Math.max(dp[len], price[index] + dp[len - rodLength]);
            }
        }

        return dp[n];
    }
}
