class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        } 
        int l = 1, hi = max, ans = max;
        while (l <= hi) {
            int mid = l + (hi - l) / 2;
            if (canEatInTime(mid, piles, h)) {
                ans = mid;
                hi = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return ans;
    }

    private boolean canEatInTime(int speed, int[] piles, int hours) {
        int h = 0;
        for (int pile : piles) {
            h += (pile + speed - 1) / speed;
            if (h > hours) return false;
        }
        return true;
    }
}
