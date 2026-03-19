class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k==0 || k==1) return 0;
        int count = 0;
        int product = 1;
        int n = nums.length;
        int i=0,j=0;
        while(j<n){
            product = product * nums[j];
            while(product>=k && i < n){
                product = product/nums[i];
                i++;
            }
            count = count + (j-i+1);
            j++;
        }
        return count;
    }
}