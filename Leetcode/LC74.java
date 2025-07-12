class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0,r=matrix[0].length*matrix.length-1;
        int n = matrix[0].length;
        while(l<=r){
           int mid = (l+r)/2;
           int row = mid/n;
           int col = mid%n;
           if(matrix[row][col]==target) return true;
           else if(matrix[row][col]>target) r = mid - 1;
           else l = mid + 1;
        }
        return false;
    }
}