class Solution {
    public int dominantIndex(int[] nums) {
        int max = -1;
        int sec = -1;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                sec = max;
                max = nums[i];
                index = i;
            } else if (nums[i] > sec) {
                sec = nums[i];
            }
        }
        if (max >= 2 * sec) return index;
        return -1;
    }
}
