class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int left = start;
        while (left >= 0 && nums[left] != target)left--;
        int right = start;
        while (right < nums.length && nums[right] != target)right++;
        if (left < 0) return right - start;
        if (right == nums.length) return start - left;
        return Math.min(start - left, right - start);
    }
}