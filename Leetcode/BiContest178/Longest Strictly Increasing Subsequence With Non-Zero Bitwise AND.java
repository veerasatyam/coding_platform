class Solution {
    public int longestSubsequence(int[] nums) {
        int[] xnums = nums;
        return helper(xnums, 0, -1, -1, false);
    }
    private int helper(int[] nums, int i, int prevVal, int curr, boolean started) {
        if (i == nums.length) {
            if (started && curr != 0) return 0;
            return Integer.MIN_VALUE;
        }
        int notTake = helper(nums, i + 1, prevVal, curr, started);
        int take = Integer.MIN_VALUE;
        if (!started || nums[i] > prevVal) {
            int newAnd = started ? (curr & nums[i]):nums[i];
            int next = helper(nums, i + 1, nums[i], newAnd, true);
            if (next != Integer.MIN_VALUE) {
                take = 1 + next;
            }
        }
        return Math.max(take, notTake);
    }
}
