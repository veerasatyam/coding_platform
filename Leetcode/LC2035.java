import java.util.Arrays;

class Solution {
    int[][] dp;

    public int minimumDifference(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        int n = nums.length;
        int target = sum / 2;

        dp = new int[n][target + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int s1 = target; s1 >= 0; s1--) {
            if (isSubsetSum(nums, 0, s1)) {
                int s2 = sum - s1;
                return Math.abs(s2 - s1);
            }
        }

        return sum;
    }

    boolean isSubsetSum(int[] nums, int i, int sum) {
        if (sum == 0) return true;
        if (i >= nums.length || sum < 0) return false;

        if (dp[i][sum] != -1) return dp[i][sum] == 1;

        boolean include = isSubsetSum(nums, i + 1, sum - nums[i]);
        boolean exclude = isSubsetSum(nums, i + 1, sum);

        dp[i][sum] = (include || exclude) ? 1 : 0;
        return dp[i][sum] == 1;
    }
}
