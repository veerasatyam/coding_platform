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


// pure recursion 
class Solution {
    int max;
    public int maxSubArray(int[] nums) {
        max = nums[0];
        helper(0,0,nums);
        return max;
    }
    private void helper(int i,int sum,int[] nums) {
        if (i==nums.length) return;
        sum += nums[i];
        max = Math.max(max, sum);
        if (sum<0) sum = 0;
        helper(i + 1, sum, nums);
    }
}
// brute force approach
class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for(int i = 0;i<nums.length;i++){
            int sum = 0;
            for(int j = i;j<nums.length;j++){
                sum += nums[j];
                max = Math.max(max,sum);
            }
        }
        return max;
    }
}