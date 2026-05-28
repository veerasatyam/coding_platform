class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int j = 0, i = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= target) {
                len = Math.min(len, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}




class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i = 1; i<n;i++)prefix[i] = prefix[i-1] + nums[i];
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            int find = -1;
            if(i == 0) find = target;
            else find = target + prefix[i-1];
            int index = binarySearch(prefix,i,n-1,find);
            if(index != -1) min = Math.min(min,index - i + 1);
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    private int binarySearch(int[] a,int i,int j,int target){
        int low = i;
        int high = j;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(a[mid] >= target){
                ans = mid;
                high = mid - 1;
            }else low = mid + 1;
        }
        return ans;
    }
}