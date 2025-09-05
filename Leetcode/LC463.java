class Solution {
    int rows, cols;

    public int islandPerimeter(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) return 1;
        if (grid[i][j] == 0) return 1;
        if (grid[i][j] == -1) return 0;
        grid[i][j] = -1;
        int per = 0;
        per += dfs(grid, i - 1, j);
        per += dfs(grid, i + 1, j);
        per += dfs(grid, i, j - 1);
        per += dfs(grid, i, j + 1);
        return per;
    }
}
