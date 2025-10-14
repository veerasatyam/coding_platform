class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max=0;
        for(int a : nums) max = Math.max(a,max);
        int sum=0;
        for(int i=0;i<k;i++){
            sum = sum + max;
            max++;
        }
        return sum;
    }
}