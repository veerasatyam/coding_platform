class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i = 1;i < n;i++){
            prefix[i] = nums[i] + prefix[i - 1];
        }
        int suffix = 0;
        int[] ans = new int[n];
        for(int i = n-1;i>=0;i--){
            suffix += nums[i];
            ans[i] = Math.abs(suffix - prefix[i]);
        }
        return ans;
    }
}