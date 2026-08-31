class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(grid[i], 1);
        }
        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }

        int maxOrder = 0;

        for (int r = 0; r < n; r++){
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) continue;
                int k = 1;
                while (r - k >= 0 && r + k < n && c - k >= 0 && c + k < n &&
                       grid[r - k][c] == 1 &&
                       grid[r + k][c] == 1 &&
                       grid[r][c - k] == 1 &&
                       grid[r][c + k] == 1) {
                    k++;
                }
                maxOrder = Math.max(maxOrder, k);
            }
        }

        return maxOrder;
    }
}