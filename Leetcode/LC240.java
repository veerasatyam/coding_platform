class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length,m=matrix[0].length;
        int i=0,j=m-1;
        while(i<n && j>=0){
            int current = matrix[i][j];
            if(current==target) return true;
            else if(current>target) j--;
            else i++;
        }
        return false;
    }
}