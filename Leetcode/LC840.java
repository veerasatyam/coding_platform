class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        if (n < 3 || m < 3) return 0;
        int[] dr = {-1,-1,-1,0,0,1,1,1};
        int[] dc = {-1,0,1,-1,1,-1,0,1};
        int count = 0;
        for (int i=1;i<n-1;i++) {
            for (int j=1;j<m-1;j++) {
                if (grid[i][j]! 5) continue;
                HashSet<Integer> set = new HashSet<>();
                set.add(5);
                boolean valid = true;
                for (int k=0;k<8;k++) {
                    int val = grid[i+dr[k]][j+dc[k]];
                    if (val<1 || val>9){
                        valid = false;
                        break;
                    }
                    set.add(val);
                }
                if (!valid||set.size()!=9) continue;
                int s = 15;
                if (
                    grid[i-1][j-1] + grid[i-1][j] + grid[i-1][j+1] == s &&
                    grid[i][j-1]   + grid[i][j]   + grid[i][j+1]   == s &&
                    grid[i+1][j-1] + grid[i+1][j] + grid[i+1][j+1] == s &&
                    grid[i-1][j-1] + grid[i][j-1] + grid[i+1][j-1] == s &&
                    grid[i-1][j]   + grid[i][j]   + grid[i+1][j]   == s &&
                    grid[i-1][j+1] + grid[i][j+1] + grid[i+1][j+1] == s &&
                    grid[i-1][j-1] + grid[i][j]   + grid[i+1][j+1] == s &&
                    grid[i-1][j+1] + grid[i][j]   + grid[i+1][j-1] == s
                ) count++;
            }
        }
        return count;
    }
}



class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (n<3||m<3)return 0;
        int count = 0;
        for (int i=0;i<=n-3;i++) {
            for (int j=0;j<= m-3;j++) {
                if (isMagic(grid,i,j)) {
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isMagic(int[][] grid, int r, int c) {
        boolean[] seen = new boolean[10];
        for (int i=r;i<r+3;i++) {
            for (int j=c;j<c+3;j++){
                int num = grid[i][j];
                if (num < 1 || num > 9 || seen[num])return false;
                seen[num] = true;
            }
        }
        int sum = grid[r][c]+grid[r][c+1]+grid[r][c+2];
        for (int i = 0; i < 3; i++) {
            if (grid[r+i][c]+grid[r+i][c+1]+grid[r+i][c+2]!=sum)return false;
            if (grid[r][c+i]+grid[r+1][c+i]+grid[r+2][c+i]!=sum)return false;
        }
        if (grid[r][c]+grid[r+1][c+1]+grid[r+2][c+2]!=sum)return false; 
        if (grid[r][c+2]+grid[r+1][c+1]+grid[r+2][c]!=sum) return false;
        return true;
    }
}