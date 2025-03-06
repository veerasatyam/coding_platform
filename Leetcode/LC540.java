class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0,h=nums.length-1;
        int n = nums.length;
        if(nums.length==1) return nums[0];
        if(nums[0]!=nums[1] && nums[1]==nums[2]) return nums[0];
        if(nums[n-1]!=nums[n-2]) return nums[n-1]; 
        while(l<=h)
        {
            int mid = (l+h)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) return nums[mid];
            if(nums[mid]==nums[mid-1]) mid = mid - 1;
            if(mid%2==0) l = mid + 2;
            else h = mid -1;
        } 
        return -1;
    }
}