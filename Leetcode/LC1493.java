class Solution {
    public int longestSubarray(int[] nums) {
        int zeroCount=0;
        int i=0,j=0,n=nums.length;
        int max=0;
        while(j<n){
            if(nums[j]==0) zeroCount++;
            while(zeroCount>1){
                if(nums[i]==0) zeroCount--;
                i++;
            }
         max = Math.max(max,j-i);
         j++;
        }
        return max;
    }
}