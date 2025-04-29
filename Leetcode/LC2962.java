class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxVal = Integer.MIN_VALUE;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        long count = 0; 
        int left = 0;
        int maxCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == maxVal) {
                maxCount++;
            }

            while (maxCount >= k) {
                count += (long) nums.length - right;
                if (nums[left] == maxVal) {
                    maxCount--;
                }
                left++;
            }
        }

        return count; 
    }
}