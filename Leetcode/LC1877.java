class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int p1=0,p2=nums.length-1;
        int max=0;
        while (p1<p2) {
            int sum = nums[p1]+nums[p2];
            max = Math.max(max, sum);
            p1++;
            p2--;
        } 
        return max;
    }
}