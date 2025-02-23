class Solution {
    public int subarraySum(int[] nums) {
        int totalSum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int start = Math.max(0, i - nums[i]); // Calculate start index
            for (int j = start; j <= i; j++) {  // Sum subarray elements
                totalSum += nums[j];
            }
        }
        
        return totalSum;
    }
}
