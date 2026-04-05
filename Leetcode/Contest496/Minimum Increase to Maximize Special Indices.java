class Solution {
    public long minIncrease(int[] nums) {
        int n = nums.length;
        int[] cost = new int[n-2];
        for(int i = 1;i<n-1;i++){
            cost[i-1] = Math.max(0,Math.max(nums[i-1],nums[i+1]) + 1 - nums[i]);
        }
        int odd = even = 0;
        for(int i = 0;i<n-2;i++){
            if(i % 2 == 0) even += cost[i];
            else odd += odd[i];
        }
        return Math.min(odd,even);
    }
}