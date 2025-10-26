// using recursion 
class Solution {
    public int lengthOfLIS(int[] nums) {
        return helper(nums, nums.length - 1, -1);
    }

    private int helper(int[] nums, int index, int nextIndex) {
        if (index < 0) return 0;
        int notTake = helper(nums, index - 1, nextIndex);
        int take = 0;
        if (nextIndex == -1 || nums[index] < nums[nextIndex]) {
            take = 1 + helper(nums, index - 1, index);
        }
        return Math.max(take, notTake);
    }
}

// recursion + memoization
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(nums, n - 1, -1, dp);
    }
    private int helper(int[] nums, int index, int nextIndex, int[][] dp) {
        if (index < 0) return 0;
        if (dp[index][nextIndex + 1] != -1) return dp[index][nextIndex + 1];
        int notTake = helper(nums, index - 1, nextIndex, dp);
        int take = 0;
        if (nextIndex == -1 || nums[index] < nums[nextIndex])
            take = 1 + helper(nums, index - 1, index, dp);
        return dp[index][nextIndex + 1] = Math.max(take, notTake);
    }
}


//tabulation 
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int prevIndex = index - 1; prevIndex >= -1; prevIndex--) {
                int notTake = dp[index + 1][prevIndex + 1];
                int take = 0;
                if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
                    take = 1 + dp[index + 1][index + 1];
                }
                dp[index][prevIndex + 1] = Math.max(take, notTake);
            }
        }

        return dp[0][0];
    }
}


class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 1;
        for (int i = 0; i < nums.length; i++) dp[i] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
