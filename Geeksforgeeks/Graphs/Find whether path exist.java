class Solution {
    public boolean is_Possible(int[][] grid) {
        int n = grid.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) return dfs(i, j, grid);
            }
        }
        return false;
    }
    private static boolean dfs(int i, int j, int[][] grid) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid.length || grid[i][j] == 0) return false;
        if(grid[i][j] == 2) return true;
        grid[i][j] = 0;
        boolean found = dfs(i + 1, j, grid) ||
                        dfs(i - 1, j, grid) ||
                        dfs(i, j + 1, grid) ||
                        dfs(i, j - 1, grid);
        return found;
    }
}
