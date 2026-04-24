class Solution {
    public int visibleBuildings(int nums[]) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= max) {
                count++;
                max = nums[i];
            }
        }
        return count;
    }
}