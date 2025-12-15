class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        if (n == 1) return 1;
        int l = 0;
        int r = 1;
        long count = 0;
        while (r < n) {
            while (r < n && prices[r] == prices[r - 1] - 1)r++;
            int dis = r-l;
            count += (long)dis*(dis+1)/2;
            l = r;
            r++;
        }
        if (l == n - 1) count++;
        return count;
    }
}
