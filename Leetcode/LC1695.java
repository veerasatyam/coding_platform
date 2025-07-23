class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxSum = 0, currentSum = 0;
        int i = 0, j = 0;
        int n = nums.length;

        while (j < n) {
            if (!set.contains(nums[j])) {
                set.add(nums[j]);
                currentSum += nums[j];
                maxSum = Math.max(maxSum, currentSum);
                j++;
            } else {
                set.remove(nums[i]);
                currentSum -= nums[i];
                i++;
            }
        }

        return maxSum;
    }
}
