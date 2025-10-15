class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        if (n == 0) return 0;
        int max = 1, count = 1;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) count++;
            else count = 1;
            max = Math.max(max, count);
        }

        int prevCount = 0;
        count = 1;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                count++;
            } else {
                if (prevCount > 0) ans = Math.max(ans, Math.min(prevCount, count));
                prevCount = count;
                count = 1;
            }
        }
        if (prevCount > 0) ans = Math.max(ans, Math.min(prevCount, count));
        return Math.max(ans, max / 2);
    }
}





class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int count = 1;
        int precnt = 0;
        int ans = 0;
        for (int i = 1; i < n; ++i) {
            if (nums.get(i) > nums.get(i - 1))  ++count;
            else {
                precnt = count;
                count = 1;
            }
            ans = Math.max(ans, Math.min(precnt, count));
            ans = Math.max(ans, count / 2);
        }
        return ans;
    }
}