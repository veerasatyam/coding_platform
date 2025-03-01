class Solution {
    static long[] dp;

    static void gfSeries(int N) {
        dp = new long[N + 1];
        for (int i = 0; i <= N; i++) dp[i] = Long.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            System.out.print(gfTerm(i) + " ");
        }
        System.out.println();
    }

    static long gfTerm(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;

        if (dp[n] != Long.MIN_VALUE) return dp[n];

        dp[n] = (gfTerm(n - 2) * gfTerm(n - 2)) - gfTerm(n - 1);
        return dp[n];
    }
}
