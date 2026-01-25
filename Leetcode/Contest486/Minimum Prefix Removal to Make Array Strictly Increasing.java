class Solution {
    public int minimumPrefixLength(int[] nums) {
        int n = nums.length-1;
        int i=0;
        for(i=n-1;i>=0;i--){
            if(nums[i]<nums[i+1]){
                continue;
            }else{
                break;
            }
        }
        return i+1;
    }
}