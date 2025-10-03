// recursion + memorisation
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        return Math.max(robWithDP(nums, 0, n - 2), robWithDP(nums, 1, n - 1));
    }

    private int robWithDP(int[] nums, int start, int end) {
        int len = end - start + 1;
        int[] dp = new int[len];
        
        dp[0] = nums[start];
        if (len == 1) return dp[0];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], nums[start + i] + dp[i - 2]);
        }

        return dp[len - 1];
    }
}
// tabulation and a better version 

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] temp1 = new int[n - 1];
        for (int i = 1; i < n; i++) temp1[i - 1] = nums[i];
        int[] temp2 = new int[n - 1];
        for (int i = 0; i < n - 1; i++) temp2[i] = nums[i];
        return Math.max(rober(temp1), rober(temp2));
    }

    public int rober(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[n - 1];
    }
}

