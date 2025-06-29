class Solution {
    int[][] dp;
    int mod = 1000000007;

    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        dp = new int[n][target + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }
        return count(n - 1, target, nums);
    }

    int count(int i, int sum, int[] nums) {
        if (i == 0) {
            if (sum == 0 && nums[0] == 0) return 2;
            if (sum == 0 || sum == nums[0]) return 1;
            return 0;
        }
        if (dp[i][sum] != -1) return dp[i][sum];
        int notPick = count(i - 1, sum, nums);
        int pick = 0;
        if (nums[i] <= sum) {
            pick = count(i - 1, sum - nums[i], nums);
        }
        dp[i][sum] = (pick + notPick) % mod;
        return dp[i][sum];
    }
}
