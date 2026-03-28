class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int last1 = -1;
        int last2 = -1;
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0;i<n;i++) {
            if (nums[i] == 1) {
                last1 = i;
                if (last2 != -1) minDiff = Math.min(minDiff,Math.abs(i - last2));
            } else if (nums[i]==2) {
                last2 = i;
                if (last1 != -1)minDiff = Math.min(minDiff,Math.abs(i - last1));
                
            }
        }
        return (minDiff == Integer.MAX_VALUE) ? -1 : minDiff;
    }
}