class Solution {
    public int findKthLargest(int[] nums, int k) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int l = min, h = max, ans = min;
        
        while (l <= h) {
            int mid = l + (h - l) / 2;
            
            if (countGreaterOrEqual(nums, mid) >= k) {
                ans = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        
        return ans;
    }

    private int countGreaterOrEqual(int[] nums, int mid) {
        int count = 0;
        for (int num : nums) {
            if (num >= mid) count++;
        }
        return count;
    }
}
