import java.util.ArrayList;

class Solution {
    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;

            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(dp[n - 1][i]);
        }

        return ans;
    }
}
