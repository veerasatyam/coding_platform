class Solution {
    public int minPathSum(ArrayList<ArrayList<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(triangle, 0, 0, dp);
    }

    private int helper(ArrayList<ArrayList<Integer>> triangle, int i, int j, int[][] dp) {
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int down = helper(triangle, i + 1, j, dp);
        int diagonal = helper(triangle, i + 1, j + 1, dp);

        dp[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);
        return dp[i][j];
    }
}
