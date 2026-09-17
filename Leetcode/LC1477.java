class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int i = 0;
        int j = 0;
        int currSum = 0;
        int[] minBestLenTillIndex = new int[n];
        Arrays.fill(minBestLenTillIndex, Integer.MAX_VALUE);
        int bestLen = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        while (j < n) {
            currSum += arr[j];
            while (currSum > target) {
                currSum -= arr[i];
                i++;
            }
            if (currSum == target) {
                int len = j - i + 1;
                if (i > 0 && minBestLenTillIndex[i - 1] != Integer.MAX_VALUE) {
                    result = Math.min(result, len + minBestLenTillIndex[i - 1]);
                }
                bestLen = Math.min(bestLen, len);
            }
            minBestLenTillIndex[j] = bestLen;
            j++;
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}