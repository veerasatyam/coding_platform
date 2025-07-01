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
