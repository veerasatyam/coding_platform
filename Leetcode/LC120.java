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
