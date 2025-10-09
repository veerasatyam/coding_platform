//pure Recursion
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            min = Math.min(min, helper(0, j, matrix));
        }
        return min;
    }

    private int helper(int i, int j, int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        if (j < 0 || j >= m) return (int) 1e9; 
        if (i == n - 1) return matrix[i][j]; 
        int down = matrix[i][j] + helper(i + 1, j, matrix);
        int leftDiag = matrix[i][j] + helper(i + 1, j - 1, matrix);
        int rightDiag = matrix[i][j] + helper(i + 1, j + 1, matrix);
        return Math.min(down, Math.min(leftDiag, rightDiag));
    }
}


//Recursion + Memorsisation 
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++)  Arrays.fill(dp[i],-1);
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            min = Math.min(min, helper(0, j, matrix, dp));
        }
        return min;
    }

    private int helper(int i, int j, int[][] matrix, int[][] dp) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (j < 0 || j >= m) return (int) 1e9;
        if (i == n - 1) return matrix[i][j];
        if (dp[i][j] != -1) return dp[i][j];
        int down = matrix[i][j] + helper(i + 1, j, matrix, dp);
        int leftDiag = matrix[i][j] + helper(i + 1, j - 1, matrix, dp);
        int rightDiag = matrix[i][j] + helper(i + 1, j + 1, matrix, dp);
        return dp[i][j] = Math.min(down, Math.min(leftDiag, rightDiag));
    }
}


//tabulation 
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int j = 0; j < m; j++)  dp[0][j] = matrix[0][j];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + dp[i - 1][j];
                int leftDiag = matrix[i][j];
                if (j > 0) leftDiag += dp[i - 1][j - 1];
                else leftDiag += (int) 1e9;
                int rightDiag = matrix[i][j];
                if (j < m - 1) rightDiag += dp[i - 1][j + 1];
                else rightDiag += (int) 1e9;
                dp[i][j] = Math.min(up, Math.min(leftDiag, rightDiag));
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            min = Math.min(min, dp[n - 1][j]);
        }
        return min;
    }
}
