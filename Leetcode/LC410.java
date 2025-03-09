class Solution {
    public int splitArray(int[] nums, int k) {
        int max = 0, sum = 0;
        
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        
        int l = max, h = sum, ans = 0;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            
            if (check(k, mid, nums)) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return ans;
    }
    public boolean check(int k , int mid , int[] nums){
        int sum =0;
        int x=1;
        for(int a : nums )
        {
            sum = sum + a;
            if(sum>mid)
            {
                sum = a;
                x++;
            }
            if(x>k) return false;
        }
        return true;
    }
}