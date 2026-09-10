class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp1 = new int[n][m];
        int[][] dp2 = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    dp1[i][j] = (j == 0 ? 0 : dp1[i][j - 1]) + 1;
                    dp2[i][j] = (i == 0 ? 0 : dp2[i - 1][j]) + 1;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int len = Math.min(dp1[i][j], dp2[i][j]);
                while(len > 0){
                    if(dp1[i - len + 1][j] >= len && dp2[i][j - len + 1] >= len){
                        ans = Math.max(ans, len * len);
                        break;
                    }
                    len--;
                }
            }
        }
        return ans;
    }
}