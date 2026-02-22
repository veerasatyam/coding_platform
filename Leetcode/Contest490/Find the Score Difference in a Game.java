class Solution {
    public int scoreDifference(int[] nums) {
        boolean first = true;
        int firstScore = 0;
        int secondScore = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) first = !first;
            if ((i + 1) % 6 == 0) first = !first;
            if (first) firstScore += nums[i];
            else secondScore += nums[i];
        }
        return firstScore - secondScore;
    }
}