class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] row = new int[n];
        int[] col = new int[m];
        row[0] = calucalteRowSum(0,grid);
        for(int i = 1;i<n;i++) row[i] = row[i-1] + calucalteRowSum(i,grid);
        col[0] = calucalteColSum(0,grid);
        for(int j = 1;j<m;j++) col[j] = col[j-1] + calucalteColSum(j,grid);

        int total_sum = row[n-1];
        if(total_sum % 2 != 0) return false;
        int required = total_sum/2;
        boolean found = find(row,required) || find(col,required);
        return found;
    }
    private int calucalteRowSum(int r,int grid[][]){
        int sum = 0;
        for(int i = 0;i<grid[0].length;i++){
            sum += grid[r][i];
        }
        return sum;
    }
    private int calucalteColSum(int c,int[][] grid){
        int sum = 0;
        for(int i=0;i<grid.length;i++){
            sum += grid[i][c];
        }
        return sum;
    }
    private boolean find(int[] a,int x){
        for(int i : a) if(x==i) return true;
        return false;
    }
}


// without extra space and accepted solution

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
            }
        }
        if ((total & 1L) == 1L) return false;
        long target = total / 2;
        long horizontalSum = 0;
        for (int top = 0; top < m - 1; top++) {
            for (int col = 0; col < n; col++) {
                horizontalSum += grid[top][col];
            }
            if (horizontalSum == target) return true;
        }

        long verticalSum = 0;
        for (int left = 0; left < n - 1; left++) {
            for (int row = 0; row < m; row++) {
                verticalSum += grid[row][left];
            }
            if (verticalSum == target) return true;
        }
        return false;
    }
}