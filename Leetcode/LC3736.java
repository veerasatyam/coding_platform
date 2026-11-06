class Solution {
    public int minMoves(int[] nums) {
        int max = nums[0];
        for(int a : nums) max = Math.max(max,a);
        int moves = 0;
        for(int a : nums) moves += max - a;
        return moves;
    }
}