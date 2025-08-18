class Solution {
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=1;i<nums.length;i++) res[i]=res[i-1]+res[i];
        return res;
    }
}