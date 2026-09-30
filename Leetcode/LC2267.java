// pure recursion, TLE
class Solution {
    public boolean hasValidPath(char[][] grid) {
        if(grid[0][0] != '(' || grid[grid.length-1][grid[0].length-1] != ')') return false;
        return helper(grid,0,0,0);
    }
    private boolean helper(char[][] grid,int count,int i,int j){
        if(i == grid.length || j == grid[0].length || count < 0) return false;
        if(i == grid.length-1 && j == grid[0].length-1) return count == 1;
        if(grid[i][j] == '(') count++;
        else count--;
        return helper(grid,count,i + 1, j) || helper(grid,count,i,j + 1);
    }
}


// recursion + memoization, TLE
class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] != '(' || grid[m - 1][n - 1] != ')')return false;
        if ((m + n - 1) % 2 != 0) return false;
        Boolean[][][] dp = new Boolean[m][n][m + n];
        return helper(grid, 0, 0, 0, dp);
    }
    private boolean helper(char[][] grid, int i, int j, int count,Boolean[][][] dp) {
        if (i >= grid.length || j >= grid[0].length || count < 0) return false;
        if (grid[i][j] == '(') {
            count++;
        } else {
            count--;
        }
        if (count < 0) return false;
        if (dp[i][j][count] != null)  return dp[i][j][count];
        if (i == grid.length - 1 && j == grid[0].length - 1) return dp[i][j][count] = (count == 0);
        return dp[i][j][count] = helper(grid, i + 1, j, count, dp) || helper(grid, i, j + 1, count, dp);
    }
}






//Approach-1 (Top Down / Recursion + Memoization)
//T.C : O(m*n*(m+n))
//S.C : O(m*n*(m+n))
class Solution {
    int m, n;
    int[][][] t;

    public boolean solve(int i, int j, int openCount, char[][] grid) {
        openCount += (grid[i][j] == '(') ? 1 : -1;
        if (openCount < 0) return false;
        if (t[i][j][openCount] != -1) {
            return t[i][j][openCount] == 1;
        }
        if (i == m - 1 && j == n - 1) {
            t[i][j][openCount] = (openCount == 0) ? 1 : 0;
            return openCount == 0;
        }
        if (i + 1 < m) {
            if (solve(i + 1, j, openCount, grid)) {
                t[i][j][openCount] = 1;
                return true;
            }
        }
        if (j + 1 < n) {
            if (solve(i, j + 1, openCount, grid)) {
                t[i][j][openCount] = 1;
                return true;
            }
        }
        t[i][j][openCount] = 0;
        return false;
    }

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if ((m + n - 1) % 2 == 1)
            return false;
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(')
            return false;

        t = new int[m][n][201];
        for (int[][] row : t)
            for (int[] col : row)
                Arrays.fill(col, -1);

        return solve(0, 0, 0, grid);
    }
}