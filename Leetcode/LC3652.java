// brute force O(n*k)
class Solution {
    public long maxProfit(int[] prices, int[] s, int k) {
        int n = prices.length;
        long base = 0;
        for (int i = 0;i<n;i++) {
            base += (long)prices[i]*s[i];
        }
        long ans = base;
        for (int i = 0; i + k <= n; i++) {
            long remove = 0;
            long add = 0;
            for (int j = i; j < i + k; j++) {
                remove += (long) prices[j] * s[j];
                if(j>i+k/2)add += (long) prices[j];
            }
            long newProfit = base - remove + add;
            ans = Math.max(ans, newProfit);
        }

        return ans;
    }
}


// optimal solution
class Solution {
    public long maxProfit(int[] prices, int[] s, int k) {
        int n = prices.length;
        long base = 0;
        long[] prevsum = new long[n + 1];
        long[] Sprevsum = new long[n + 1];
        for (int i=0;i<n;i++){
            base += (long)prices[i]*s[i];
            prevsum[i+1] = prevsum[i]+prices[i];
            Sprevsum[i+1] = Sprevsum[i]+(long)prices[i]*s[i];
        }
        long ans = base;
        for (int i=0;i+k<=n;i++) {
            long remove = Sprevsum[i + k] - Sprevsum[i];
            int mid = (2 * i + k) / 2;
            long add = prevsum[i + k] - prevsum[mid];
            long newProfit = base - remove + add;
            ans = Math.max(ans, newProfit);
        }
        return ans;
    }
}

