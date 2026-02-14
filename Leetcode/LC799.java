class Solution {
    public double champagneTower(int poured, int row, int col) {
        double[][] dp = new double[101][101];
        dp[0][0] = poured;
        for (int i = 0;i<=row;i++) {
            for (int j=0;j<=i;j++) {
                if (dp[i][j] > 1) {
                    double remaining = (dp[i][j]-1)/2.0;
                    dp[i][j] = 1.0;
                    dp[i+1][j] += remaining;
                    dp[i+1][j+1] += remaining;
                }
            }
        }

        return Math.min(1, dp[row][col]);
    }
}
