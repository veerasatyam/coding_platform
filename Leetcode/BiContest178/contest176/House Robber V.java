// recursion + memoization approach
class Solution {
    public long rob(int[] nums, int[] colors) {
        int n = nums.length;
        long[][] dp = new long[n][2];
        for(long[] row : dp) Arrays.fill(row, -1);
        return helper(nums, colors, 0, 0, dp);
    }

    private long helper(int[] nums, int[] colors, int index, int prevTaken, long[][] dp) {
        if (index >= nums.length) return 0;
        if (dp[index][prevTaken] != -1) return dp[index][prevTaken];
        long skip = helper(nums, colors, index + 1, 0, dp);
        long take = 0;
        if (prevTaken == 0 || colors[index] != colors[index - 1]) {
            take = nums[index] + helper(nums, colors, index + 1, 1, dp);
        }
        dp[index][prevTaken] = Math.max(skip, take);
        return dp[index][prevTaken];
    }
}


// pure recursive approach without dp
class Solution {
    public long rob(int[] nums, int[] colors) {
        return helper(nums, colors, 0, 0);
    }
    private long helper(int[] nums, int[] colors, int index, int prevTaken) {
        if (index >= nums.length) return 0;
        long skip = helper(nums, colors, index + 1, 0);
        long take = 0;
        if (prevTaken == 0 || colors[index] != colors[index - 1]) {
            take = nums[index] + helper(nums, colors, index + 1, 1);
        }
        return Math.max(skip, take);
    }
}