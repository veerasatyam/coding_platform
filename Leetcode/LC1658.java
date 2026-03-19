class Solution {
    public int minOperations(int[] nums, int x) {
        int sum=0,tot=0,min=Integer.MIN_VALUE,l=0;
        for(int i:nums)
        tot+=i;
        int target=tot-x;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(sum>target&&l<=i)
            sum-=nums[l++];    
            if(sum==target)
            min=Math.max(min,i-l+1);
        }
        return min==Integer.MIN_VALUE?-1:nums.length-min;
    }
}