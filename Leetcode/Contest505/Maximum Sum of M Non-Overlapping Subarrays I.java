// brute force approch using recursion
class Solution {
    public long maximumSum(int[] nums, int m, int l, int r) {
        return solve(0,m,l,r,nums,false);
    }

    private long solve(int i, int subLeft, int l, int r, int[] nums, boolean pickedAtLeastOne) {
        if (subLeft == 0) {
            return pickedAtLeastOne ? 0 : Long.MIN_VALUE / 2;
        }
        if (i >= nums.length) {
            return pickedAtLeastOne ? 0 : Long.MIN_VALUE / 2;
        }
        long maxResult = solve(i + 1,subLeft,l,r,nums,pickedAtLeastOne);
        long currentSubarraySum = 0;
        for (int j = i; j < nums.length; j++) {
            currentSubarraySum += nums[j];
            int len = j - i + 1;
            if (len >= l && len <= r) {
                long remainingMax = solve(j + 1,subLeft - 1,l,r,nums,true);
                if (remainingMax != Long.MIN_VALUE / 2)
                    maxResult = Math.max(maxResult,currentSubarraySum + remainingMax);
            }
            if (len > r) break;
        }
        return maxResult;
    }
}

// brute force approch using recursion with memoization
class Solution {
    public long maximumSum(int[] nums, int m, int l, int r){
        long[][] dp = new long[nums.length + 1][m + 1];
        for(long[] row : dp) Arrays.fill(row,Long.MIN_VALUE / 2);
        return solve(0,m,l,r,nums,false,dp);
    }

    private long solve(int i, int subLeft, int l, int r, int[] nums, boolean pickedAtLeastOne,long[][] dp) {
        if (subLeft == 0) {
            return pickedAtLeastOne ? 0 : Long.MIN_VALUE / 2;
        }
        if (i >= nums.length) {
            return pickedAtLeastOne ? 0 : Long.MIN_VALUE / 2;
        }
        if(dp[i][subLeft] != Long.MIN_VALUE / 2) return dp[i][subLeft];
        long maxResult = solve(i + 1,subLeft,l,r,nums,pickedAtLeastOne,dp);
        long currentSubarraySum = 0;
        for (int j = i; j < nums.length; j++) {
            currentSubarraySum += nums[j];
            int len = j - i + 1;
            if (len >= l && len <= r) {
                long remainingMax = solve(j + 1,subLeft - 1,l,r,nums,true,dp);
                if (remainingMax != Long.MIN_VALUE / 2)
                    maxResult = Math.max(maxResult,currentSubarraySum + remainingMax);
            }
            if (len > r) break;
        }
        return dp[i][subLeft] = maxResult;
    }
}






// brute force approch using recursion with memoization and prefix sum
// prefix sum isn't necessary but it can help to calculate the sum of subarray in O(1) time instead of O(n) time but it doesn't change the overall time complexity of the solution
class Solution {
    public long maximumSum(int[] nums, int m, int l, int r){
        long[][] dp = new long[nums.length + 1][m + 1];
        long[] prefixSum  = new long[nums.length];
        prefixSum[0] = nums[0];
        for(int i = 1;i < nums.length;i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        for(long[] row : dp) Arrays.fill(row,Long.MIN_VALUE / 2);
        return solve(0,m,l,r,nums,false,dp,prefixSum);
    }

    private long solve(int i, int subLeft, int l, int r, int[] nums, boolean pickedAtLeastOne,long[][] dp,long[] prefixSum) {
        if (subLeft == 0) {
            return pickedAtLeastOne ? 0 : Long.MIN_VALUE / 2;
        }
        if (i >= nums.length) {
            return pickedAtLeastOne ? 0 : Long.MIN_VALUE / 2;
        }
        if(dp[i][subLeft] != Long.MIN_VALUE / 2) return dp[i][subLeft];
        long maxResult = solve(i + 1,subLeft,l,r,nums,pickedAtLeastOne,dp,prefixSum);
        for (int j = i; j < nums.length; j++) {
            int len = j - i + 1;
            if (len >= l && len <= r) {
                long currentSubarraySum = prefixSum[j] - (i > 0 ? prefixSum[i - 1] : 0);
                long remainingMax = solve(j + 1,subLeft - 1,l,r,nums,true,dp,prefixSum);
                if (remainingMax != Long.MIN_VALUE / 2)
                    maxResult = Math.max(maxResult,currentSubarraySum + remainingMax);
            }
            if (len > r) break;
        }
        return dp[i][subLeft] = maxResult;
    }
}



// with differnt code structure but same logic
import java.util.Arrays;

public class Solution {
    private Long[][] memo;
    private long[] pref;

    public long maximumSum(int[] nums, int m, int l, int r) {
        int n = nums.length;
        pref = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + nums[i];
        }
        memo = new Long[n + 1][m + 1];
        return solve(0, m, l, r, n, nums);
    }

    private long solve(int i, int j, int l, int r, int n, int[] nums) {
        if (i >= n || j == 0) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        long maxSum = solve(i + 1, j, l, r, n, nums);
        int minLen = l;
        int maxLen = Math.min(r, n - i);
        for (int len = minLen; len <= maxLen; len++) {
            long currentSubarraySum = pref[i + len] - pref[i];
            long nextSum = solve(i + len, j - 1, l, r, n, nums);
            maxSum = Math.max(maxSum, currentSubarraySum + nextSum);
        }
        return memo[i][j] = maxSum;
    }
}