import java.util.*;
//pure recursion 
public class Solution {
    public static int findWays(int[] num, int tar) {
        int n = num.length;
        return helper(n - 1, tar, num);
    }

    private static int helper(int i, int tar, int[] num) {
       
        if (i == 0) {
           if(nums[0]==0 && tar==0) return 2;
           if(tar == num[0]) ? 1 : 0;
        } 
        if (tar < 0) return 0;
        int notTake = helper(i - 1, tar, num);
        int take = 0;
        if (num[i] <= tar) take = helper(i - 1, tar - num[i], num);
        return take + notTake;
    }
}

// recursion + memorization 
public class Solution {
    public static int findWays(int[] num, int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return helper(n - 1, tar, num,dp);
    }

    private static int helper(int i, int tar, int[] num,int[][] dp) {
        if (tar == 0) return 1;
        if (i == 0) return (tar == num[0]) ? 1 : 0;
        if (tar < 0) return 0;
        if(dp[i][tar]!=-1) return dp[i][tar];
        int notTake = helper(i - 1, tar, num,dp);
        int take = 0;
        if (num[i] <= tar) take = helper(i - 1, tar - num[i], num,dp);
        dp[i][tar] = take + notTake;
        return dp[i][tar];
    }
}


//tabulation 
import java.util.*;
public class Solution {
    public static int MOD = 1_000_000_007;
    public static int findWays(int[] num, int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar + 1];
        if (num[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;
        if (num[0] != 0 && num[0] <= tar) dp[0][num[0]] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= tar; j++) {
                int notTake = dp[i - 1][j];
                int take = 0;
                if (num[i] <= j) take = dp[i - 1][j - num[i]];
                dp[i][j] = (take + notTake) % MOD;
            }
        }
        return dp[n - 1][tar];
    }
}


