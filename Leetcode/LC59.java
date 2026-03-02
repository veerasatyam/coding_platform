// use 4 pointers to keep track of the current row and column we are filling in the matrix
class Solution {
    public int[][] generateMatrix(int n) {
        int last = n*n;
        int first = 1;
        int[][] matrix = new int[n][n];
        int left = 0,right = n-1;
        int top = 0,bottom = n-1;
        while(top <= bottom && left <= right){
            for(int i = left;i<=right;i++)matrix[top][i] = first++;
            top++;
            for(int i = top;i<=bottom;i++) matrix[i][right] = first++;
            right--;
            if(top <= bottom){
                for(int i = right;i>=left;i--) matrix[bottom][i] = first++;
                bottom--;
            }
            if(left <= right){
                for(int i=bottom;i>=top;i--) matrix[i][left] = first++;
                left++;
            }
        }
        return matrix;
    }
}