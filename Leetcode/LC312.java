// pure recursion
class Solution {
    public int maxCoins(int[] nums) {
        int[] num = new int[nums.length + 2];
        num[0] = 1;
        num[num.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) num[i + 1] = nums[i];
        return helper(num, 1, nums.length);
    }
    private int helper(int[] nums, int i, int j) {
        if (i > j) return 0;
        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            int gain = nums[i - 1] * nums[k] * nums[j + 1] + helper(nums, i, k - 1) + helper(nums, k + 1, j);
            max = Math.max(max, gain);
        }
        return max;
    }
}


//memoization

class Solution {
    public int maxCoins(int[] nums) {
        int[] num = new int[nums.length + 2];
        num[0] = 1;
        num[num.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) num[i + 1] = nums[i];
        int n = num.length;
        int[][] dp = new int[n][n];
        for (int a = 0; a < n; a++) Arrays.fill(dp[a], -1);
        return helper(num, 1, nums.length, dp);
    }
    private int helper(int[] nums, int i, int j, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            int gain = nums[i - 1] * nums[k] * nums[j + 1] + helper(nums, i, k - 1, dp) + helper(nums, k + 1, j, dp);
            max = Math.max(max, gain);
        }
        return dp[i][j] = max;
    }
}


//tabulation

class Solution {
    public int maxCoins(int[] nums) {
        int[] num = new int[nums.length + 2];
        num[0] = 1;
        num[num.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) num[i + 1] = nums[i];
        int n = nums.length;   
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                int max = 0;
                for (int k = i; k <= j; k++) {
                    int gain = num[i - 1] * num[k] * num[j + 1]
                             + dp[i][k - 1]
                             + dp[k + 1][j];

                    max = Math.max(max, gain);
                }
                dp[i][j] = max;
            }
        }
        return dp[1][n];
    }
}

