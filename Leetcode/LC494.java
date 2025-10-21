// recursion based
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return count(nums, 0, 0, target);
    }

    int count(int[] nums, int index, int sum, int target) {
        if (index == nums.length) {
            return sum == target ? 1 : 0;
        }
        int add = count(nums, index + 1, sum + nums[index], target);
        int subtract = count(nums, index + 1, sum - nums[index], target);
        return add + subtract;
    }
}

// recursion + memoiation linked to count partitions with given differnce problem
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
         return countPartitions(nums.length,target,nums)
    }
    public static int countPartitions(int n, int d, int[] arr) {
        int sum = 0;
        for (int num : arr) sum += num;
        if ((sum - d) % 2 != 0 || sum < d) return 0;
        int target = (sum - d) / 2;
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1);         
        return helper(arr, n - 1, target, dp);
    }

    private static int helper(int[] arr, int index, int target, int[][] dp) {
        if (index == 0) {
            if (target == 0 && arr[0] == 0) return 2;
            if (target == 0 || target == arr[0]) return 1;
            return 0;
        }
        if (dp[index][target] != -1) return dp[index][target];
        int notTake = helper(arr, index - 1, target, dp);
        int take = 0;
        if (arr[index] <= target) take = helper(arr, index - 1, target - arr[index], dp);
        return dp[index][target] = take + notTake;
    }
}