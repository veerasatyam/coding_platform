//Pure Recursion 
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return solve(0, 0, triangle);
    }

    private int solve(int i, int j, List<List<Integer>> tri) {
        if (i == tri.size() - 1) return tri.get(i).get(j);
        int down = tri.get(i).get(j) + solve(i + 1, j, tri);
        int diag = tri.get(i).get(j) + solve(i + 1, j + 1, tri);
        return Math.min(down, diag);
    }
}


//recursion + memorization 

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        return solve(0, 0, triangle, dp);
    }

    private int solve(int i, int j, List<List<Integer>> tri, int[][] dp) {
        if (i == tri.size() - 1) return tri.get(i).get(j);
        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        int down = tri.get(i).get(j) + solve(i + 1, j, tri, dp);
        int diag = tri.get(i).get(j) + solve(i + 1, j + 1, tri, dp);
        return dp[i][j] = Math.min(down, diag);
    }
}


//tabulation
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                matrix[i][j] = row.get(j);
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
            }
        }

        return matrix[0][0];
    }
}
