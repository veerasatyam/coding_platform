class Solution {
    public int maximumCandies(int[] candies, long k) {
        long totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }
        if (totalCandies < k) {
            return 0;
        }
        
        int left = 0;
        int right = (int) (totalCandies / k); 
        int ans = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (mid == 0) {
                if (totalCandies >= k) {
                    ans = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (canGive(candies, mid, k)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return ans;
    }

    private boolean canGive(int[] candies, int mid, long k) {
        long count = 0;
        for (int candy : candies) {
            count += candy / mid;
        }
        return count >= k;
    }
}