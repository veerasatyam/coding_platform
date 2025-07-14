class Solution {
    public int maxSubArray(int[] nums) {
        int maxim = nums[0];
        int sum = 0;
        for(int i : nums) {
            sum += i;
            maxim =Math.max(sum,maxim);
            sum = sum < 0 ? 0 : sum;
        }
        return maxim;
    }
}