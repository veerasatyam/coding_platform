class Solution {
    public int finalElement(int[] nums) {
        int[] xnums = nums;
        if(xnums.length == 1) return xnums[0];
        return Math.max(nums[0], nums[nums.length - 1]);
    }
}