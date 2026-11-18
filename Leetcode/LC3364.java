
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int ans = Integer.MAX_VALUE;
        int n = nums.size();

        int currSum = 0;
        int i = 0, j = 0;

        while (j < n) {
            currSum += nums.get(j);
            int size = j - i + 1;
            while (size > r) {
                currSum -= nums.get(i);
                i++;
                size = j - i + 1;
            }
            if (size >= l && currSum > 0) {
                ans = Math.min(ans, currSum);
            }
            int tempSum = currSum;
            for (int k = i; k < j && size > l; k++) {
                tempSum -= nums.get(k);
                size--;
                if (tempSum > 0) {
                    ans = Math.min(ans, tempSum);
                }
            }
            j++;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}