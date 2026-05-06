class Solution {
    public int minOperations(int[] nums) {
        int ops = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= prev) {
                ops += prev + 1 - nums[i];
                prev = prev + 1;
            } else {
                prev = nums[i];
            }
        }
        return ops;
    }
}