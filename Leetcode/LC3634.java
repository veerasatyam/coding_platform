class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0,r=n;
        while(l<r){
            int mid = l + (r-l)/2;
            if(check(nums,mid,k)){
                r = mid;
            }else{
                l = mid+1;  
            }
        }
        return l;
    }
    private boolean check(int[] nums,int remove,int k){
        int n = nums.length;
        int len = n - remove;
        for (int i = 0; i + len - 1 < n; i++) {
            if ((long) nums[i + len - 1] <= (long) nums[i] * k) {
                return true;
            }
        }
        return false;
    }
}



// option 2
class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int maxRemove = 0;
        int i = 0;
        for (int j = 0; j < n; j++) {
            while ((long) nums[j] > (long) nums[i] * k) i++;
            maxRemove = Math.max(maxRemove, j - i + 1);
        }
        return n-maxRemove;
    }
}