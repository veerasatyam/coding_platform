import java.util.Arrays;
// please revice the subsets sum equal to k before this 
//this solution works only when the array contains non negative integers
// recursion + memorization 
class Solution {
    int[][] dp;
    public int minimumDifference(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        int n = nums.length;
        int target = sum / 2;

        dp = new int[n][target + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int s1 = target; s1 >= 0; s1--) {
            if (isSubsetSum(nums, 0, s1)) {
                int s2 = sum - s1;
                return Math.abs(s2 - s1);
            }
        }

        return sum;
    }
    boolean isSubsetSum(int[] nums, int i, int sum) {
        if (sum == 0) return true;
        if (i >= nums.length || sum < 0) return false;

        if (dp[i][sum] != -1) return dp[i][sum] == 1;

        boolean include = isSubsetSum(nums, i + 1, sum - nums[i]);
        boolean exclude = isSubsetSum(nums, i + 1, sum);

        dp[i][sum] = (include || exclude) ? 1 : 0;
        return dp[i][sum] == 1;
    }
}



//tabulation 
import java.util.*;

class Solution {
    public int minimumDifference(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int x : arr) sum += x;

        boolean[][] dp = new boolean[n][sum / 2 + 1];
        for (int i = 0; i < n; i++) dp[i][0] = true;
        if (Math.abs(arr[0]) <= sum / 2) dp[0][arr[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= sum / 2; target++) {
                boolean notTake = dp[i - 1][target];
                boolean take = false;
                if (target >= arr[i]) take = dp[i - 1][target - arr[i]];
                dp[i][target] = take || notTake;
            }
        }

        int minDiff = Integer.MAX_VALUE;
        for (int s1 = 0; s1 <= sum / 2; s1++) {
            if (dp[n - 1][s1]) {
                int s2 = sum - s1;
                minDiff = Math.min(minDiff, Math.abs(s2 - s1));
            }
        }
        return minDiff;
    }
}
