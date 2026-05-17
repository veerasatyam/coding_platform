class Solution {
    
    private long powLimit(long x, int k, long limit) {
        long res = 1;
        for (int i = 0; i < k; i++) {
            if (x == 0) return 0;
            if (res > limit / x) return limit + 1;
            res *= x;
        }
        return res;
    }

    private long floorRoot(long r, int k) {
        long lo = 0, hi = (long) Math.pow(r, 1.0 / k) + 2;
        long ans = 0;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (powLimit(mid, k, r) <= r) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    private long ceilRoot(long l, int k) {
        long lo = 0, hi = (long) Math.pow(l == 0 ? 1 : l, 1.0 / k) + 2;
        long ans = hi;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (powLimit(mid, k, Long.MAX_VALUE) >= l) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
    public long countKthPower(long l, long r, int k){
        if (k == 1) return r - l + 1;
        long xMax = floorRoot(r, k);
        long xMin = ceilRoot(l, k);
        if (xMax < xMin) return 0;
        return xMax - xMin + 1;
    }
}