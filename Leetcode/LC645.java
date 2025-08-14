class Solution {
    public int[] findErrorNums(int[] nums) {
         int dup = -1, missing = -1;
    for (int x : nums) {
        int idx = Math.abs(x) - 1;
        if (nums[idx] < 0) dup = Math.abs(x);
        else nums[idx] *= -1;
    }
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] > 0) missing = i + 1;
    }
    return new int[]{dup, missing};
    }
}
