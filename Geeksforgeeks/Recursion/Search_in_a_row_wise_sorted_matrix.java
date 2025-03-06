class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchRowMatrix(int[][] mat, int x) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) return false;
        
        int l = 0, h = mat.length * mat[0].length - 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            int row = mid / mat[0].length;
            int col = mid % mat[0].length;

            if (mat[row][col] == x) return true;
            else if (mat[row][col] > x) h = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
}