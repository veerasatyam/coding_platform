class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum =0;
        int max_sum=0;
        for(int i=1;i<nums.length-1;i++)
        {
            if(nums[i]>nums[i-1])
            {
                sum = sum + nums[i-1];
            }
            else
            {
                sum = sum + nums[i];
                max_sum = Math.max(sum,max_sum);
                sum = 0;
            }
        }
        if(sum!=0) sum=sum+nums[nums.length-1];
        return Math.max(sum,max_sum);
    }
}