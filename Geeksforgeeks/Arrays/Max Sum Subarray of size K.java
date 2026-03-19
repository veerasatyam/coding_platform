class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int n = arr.length;
        int j = 0, i = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        while (j < n) {
            sum += arr[j];
            while ((j - i + 1) > k) {
                sum -= arr[i];
                i++;
            }
            max = Math.max(sum, max);
            j++;
        }
        return max;
    }
}
