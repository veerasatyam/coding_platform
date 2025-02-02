class Solution {
    public boolean isArraySpecial(int[] nums) {
        for(int i=0 ;i<nums.length-1;i++)
        {
            int x = nums[i] + nums[i+1];
            if(x%2==0)
            {
                return false;
            }
        }
        return true;
    }
}