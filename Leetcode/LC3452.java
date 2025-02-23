class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int sum = 0;
        for(int i=k-1;i>=nums.length-k-1;i++)
        {
            sum += nums[i];
        }
        return sum;
    }
}