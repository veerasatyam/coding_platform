// pure recursion
class Solution {
    public boolean canJump(int[] nums) {
        return helper(nums, 0, nums[0]);
    }
    private boolean helper(int[] nums, int i, int j) {
        if (i >= nums.length - 1) return true;
        for (int k = i + 1; k <= i + j && k < nums.length; k++) if (helper(nums, k, nums[k])) return true;
        return false;
    }
}

// memoiation
class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return dfs(nums, 0, dp);
    }
    private boolean dfs(int[] nums, int i, int[] dp) {
        if (i >= nums.length - 1) return true;
        if (dp[i] != -1) return dp[i] == 1;
        int maxJump = nums[i];
        for (int next = i + 1; next <= i + maxJump && next < nums.length; next++) {
            if (dfs(nums, next, dp)) {
                dp[i] = 1;
                return true;
            }
        }
        dp[i] = 0;
        return false;
    }
}



class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }
        return goal == 0;
    }
}
