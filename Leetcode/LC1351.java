class Solution {
    public int countNegatives(int[][] grid) {
        int count=0;
        int row = grid.length-1,col=0;
        int m = grid[0].length;
        while(row>=0 && col<m)
        {
            if(grid[row][col]<0)
            {
                row--;
                count = count + m-col;
            }else{
                col++;
            }
        }
        return count;
    }
}