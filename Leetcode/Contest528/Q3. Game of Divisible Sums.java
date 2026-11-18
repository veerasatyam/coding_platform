class Solution {
    public long maxDifference(int[] nums) {
        long[][] dp = new long[nums.length][2];
        for(long[] row : dp) {
            Arrays.fill(row, Long.MIN_VALUE);
        }
        return helper(nums, 0, 0);
    }

    private long helper(int[] nums, int i, int aliceTurn, long[][] dp) {
        if (i >= nums.length) return 0;
        if(dp[i][aliceTurn] != Long.MIN_VALUE) return dp[i][aliceTurn];
        if (aliceTurn == 0) {
            long sum = nums[i];
            int turn = (sum % 3 == 0) ? 1 : 0;
            long takeOne = sum + helper(nums, i + 1, turn,dp);
            long takeTwo = Long.MIN_VALUE;
            if (i + 1 < nums.length) {
                sum = (long) nums[i] + nums[i + 1];
                turn = (sum % 3 == 0) ? 1 : 0;
                takeTwo = sum + helper(nums, i + 2, turn,dp);
            }
            return dp[i][aliceTurn] = Math.max(takeOne, takeTwo);
        }
        else {
            long sum = nums[i];
            int turn = (sum % 3 == 0) ? 0 : 1;
            long takeOne = -sum + helper(nums, i + 1, turn, dp);
            long takeTwo = Long.MAX_VALUE;
            if (i + 1 < nums.length) {
                sum = (long) nums[i] + nums[i + 1];
                turn = (sum % 3 == 0) ? 0 : 1;
                takeTwo = -sum + helper(nums, i + 2, turn, dp);
            }
            return dp[i][aliceTurn] = Math.min(takeOne, takeTwo);
        }
    }
}