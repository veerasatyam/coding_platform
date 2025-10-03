//memorization + recursion
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


//Tabulation method 
class Solution {
    public int rob(int[] nums) {
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

//space optimisation 

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int prev2 = nums[0];           
        int prev1 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int curr = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
