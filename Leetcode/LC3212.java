class Solution {
    public int numberOfSubmatrices(char[][] grid) {
         int n = grid.length;
         int m = grid[0].length;
        int[][] px = new int[n][m];
        int[][] py = new int[n][m];
        px[0][0] = grid[0][0] == 'X' ? 1 : 0;
        py[0][0] = grid[0][0] == 'Y' ? 1 : 0;
        for(int i = 1;i<n;i++){
            px[i][0] = px[i-1][0] + (grid[i][0] == 'X' ? 1 : 0);
            py[i][0] = py[i-1][0] + (grid[i][0] == 'Y' ? 1 : 0);
        }
        for(int j = 1;j<m;j++){
            px[0][j] = px[0][j-1] + (grid[0][j] == 'X' ? 1 : 0);
            py[0][j] = py[0][j-1] + (grid[0][j] == 'Y' ? 1 : 0);
        }
        for (int i = 1; i < n; i++) {
            for(int j = 1;j < m;j++){
                px[i][j] = px[i-1][j] + px[i][j-1] - px[i-1][j-1] + (grid[i][j] == 'X' ? 1 : 0);
                py[i][j] = py[i-1][j] + py[i][j-1] - py[i-1][j-1] + (grid[i][j] == 'Y' ? 1 : 0);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for(int j = 0;j < m;j++){
                if(px[i][j] == py[i][j]  && px[i][j] > 0){
                    count++;
                }
            }
        }
        return count;
    }
}




// brute force
class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int xCount = 0;
                int yCount = 0;
                for (int k = 0; k <= i; k++) {
                    for (int l = 0; l <= j; l++) {
                        if (grid[k][l] == 'X') xCount++;
                        else if (grid[k][l] == 'Y') yCount++;
                    }
                }
                if (xCount > 0 && xCount == yCount) {
                    count++;
                }
            }
        }
        return count;
    }
}