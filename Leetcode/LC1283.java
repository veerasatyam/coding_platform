class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = getMax(nums);
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (getSum(nums, mid) > threshold) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    
    private int getMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
        }
        return max;
    }

    private int getSum(int[] nums, int divisor) {
        int sum = 0;
        for (int num : nums) {
            sum += (int) Math.ceil((double) num / divisor);
        }
        return sum;
    }
}
