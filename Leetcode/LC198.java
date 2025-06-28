class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return calculate(nums, n - 1, dp);
    }
    int calculate(int[] nums, int i, int[] dp) {
        if (i < 0) return 0;
        if (dp[i] != -1) return dp[i];
        dp[i] = Math.max(calculate(nums, i - 1, dp), nums[i] + calculate(nums, i - 2, dp));
        return dp[i];
    }
}
