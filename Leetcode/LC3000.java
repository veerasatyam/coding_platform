class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n = dimensions.length;
        int maxDiagSq = 0;  // store squared diagonal
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int length = dimensions[i][0];
            int width = dimensions[i][1];
            int diagSq = length * length + width * width;
            int area = length * width;

            if (diagSq > maxDiagSq) {
                maxDiagSq = diagSq;
                maxArea = area;
            } else if (diagSq == maxDiagSq && area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}
