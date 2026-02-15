class Solution {
    public int minimumK(int[] nums) {
        int left = 1, right = 100000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canReduce(nums, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canReduce(int[] nums, int k) {
        long count = 0;
        for (int num : nums) {
            count += (num+k-1)/k;
            if (count >(long)k*k) return false;
        }
        return count <= (long) k * k;
    }
}
