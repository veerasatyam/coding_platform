class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        if (k == 1) {
            int[] freq = new int[51];
            for (int num : nums) freq[num]++;
            for (int i = 50; i >= 0; i--) {
                if (freq[i] == 1) {
                    return i;
                }
            }
            return -1;
        }
        if (k == n) {
            int ans = 0;
            for (int num : nums) ans = Math.max(ans, num);
            return ans;
        }
        int first = nums[0];
        int last = nums[n - 1];
        int firstCount = 0;
        int lastCount = 0;
        for (int num : nums) {
            if (num == first) firstCount++;
            if (num == last) lastCount++;
        }
        if (firstCount == 1 && lastCount == 1) return Math.max(first, last);
        if (firstCount == 1)  return first;
        if (lastCount == 1)  return last;
        return -1;
    }
}