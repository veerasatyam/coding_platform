class Solution {
    public int maximumCount(int[] nums) {
        int l = 0, h = nums.length - 1;
        int index = 0;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] >= 0) {
                index = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        int neg = index;
        int pos = nums.length - index;

        for (int i = index; i < nums.length; i++) {
            if (nums[i] == 0) {
                pos--;
            }
        }

        return Math.max(neg, pos);
    }
}
