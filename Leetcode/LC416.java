// class Solution {
//     public boolean canPartition(int[] nums) {
//         int sum = 0;
//         for (int a : nums) sum += a;
//         if (sum % 2 != 0) return false;
//         return check(nums, sum / 2, 0);
//     }

//     boolean check(int[] nums, int sum, int i) {
//         if (sum == 0) return true;
//         if (i == nums.length || sum < 0) return false;
//         boolean c1 = check(nums, sum - nums[i], i + 1);
//         boolean c2 = check(nums, sum, i + 1);
//         return c1 || c2;
//     }
// }

import java.util.Arrays;

class Solution {
    int[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int a : nums) sum += a;
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        dp = new int[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return check(nums, 0, target);
    }

    boolean check(int[] nums, int i, int sum) {
        if (sum == 0) return true;
        if (i == nums.length || sum < 0) return false;
        if (dp[i][sum] != -1) return dp[i][sum] == 1;

        boolean include = check(nums, i + 1, sum - nums[i]);
        boolean exclude = check(nums, i + 1, sum);

        dp[i][sum] = (include || exclude) ? 1 : 0;
        return dp[i][sum] == 1;
    }
}
