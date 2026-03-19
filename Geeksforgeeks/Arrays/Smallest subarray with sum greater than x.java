class Solution {
    public static int smallestSubWithSum(int x, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int currentSum = 0;
        while (j < n) {
            currentSum += nums[j];
            while (currentSum > x) {
                minLength = Math.min(minLength, j - i + 1);
                currentSum -= nums[i++];
            }
            j++;
        }
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}
