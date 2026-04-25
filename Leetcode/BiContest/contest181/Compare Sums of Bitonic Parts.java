class Solution {
    public int compareBitonicSums(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int mid = (l + r)/ 2;
            if(nums[mid] < nums[mid + 1]) l = mid + 1;
            else r = mid;
        }
        long left_sum = 0;
        long right_sum = 0;
        for(int i = 0;i<=l;i++) left_sum +=(long) nums[i];
        for(int i = l;i<nums.length;i++) right_sum += (long)nums[i];
        if(left_sum > right_sum) return 0;
        else if(left_sum < right_sum)return 1;
        return -1;
    }
}