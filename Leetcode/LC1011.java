class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0, sum = 0;
        
        for (int weight : weights) {
            sum += weight;
            max = Math.max(max, weight);
        }
        
        int l = max, h = sum, ans = 0;
        
        while (l <= h) {
            int mid = l + (h - l) / 2;
            
            if (check(days, mid, weights)) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return ans;
    }

    private boolean check(int days, int capacity, int[] weights) {
        int sum = 0, d = 1; 
        
        for (int weight : weights) {
            sum += weight;
            
            if (sum > capacity) {
                sum = weight;
                d++; 
                
                if (d > days) return false;
            }
        }
        
        return true;
    }
}
