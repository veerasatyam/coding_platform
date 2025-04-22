import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countPairs(nums, upper) - countPairs(nums, lower - 1);
    }

    private long countPairs(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        long count = 0;

        while (left < right) {
            if (nums[left] + nums[right] <= target) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}
