class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int i=0,j=1;
        int max=0;
        while(i<nums.length && j<nums.length){
            if(nums[i]==nums[j]-1) {
                j++;

            }
            else {
                max = Math.max(max,j-i);
                i=j;
                j++;
            }
        }
        return max;
    }
}