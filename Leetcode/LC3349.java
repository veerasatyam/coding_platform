class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int count = 1; 
        int prevCount = 0;

        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                count++;
            } else {
                if (Math.min(prevCount, count) >= k) return true;
                if (count / 2 >= k) return true;
                prevCount = count;
                count = 1; 
            }
        }
        if (Math.min(prevCount, count) >= k) return true;
        if (count / 2 >= k) return true;
        return false;
    }
}
