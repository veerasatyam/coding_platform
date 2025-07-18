class Solution {
    public int pivotIndex(int[] nums){
        int n=nums.length;
        int[] sumleft = new int[n];
        int[] sumRight = new int[n];
        int sum=0;
        for(int i=0;i<n;i++) {
            sum += nums[i];
            sumleft[i] = sum;
        }
        sum = 0;
        for(int i=n-1;i>=0;i--){
            sum += nums[i];
            sumRight[i] = sum;
        }
        for(int i=0;i<n;i++) if(sumleft[i]==sumRight[i]) return i;
        return -1;
    }
}