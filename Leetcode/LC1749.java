class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0, minSum = 0, currentMax = 0, currentMin = 0;

        for (int num : nums) {
            currentMax += num;
            currentMin += num;

            maxSum = Math.max(maxSum, currentMax);
            minSum = Math.min(minSum, currentMin);

            if (currentMax < 0) currentMax = 0; 
            if (currentMin > 0) currentMin = 0;
        }
        return Math.max(maxSum, Math.abs(minSum));
    }
}
