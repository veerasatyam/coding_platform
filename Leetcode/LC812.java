class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0;
        int n = points.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int[] p1 = points[i], p2 = points[j], p3 = points[k];
                    
                    double area = 0.5 * Math.abs(
                        p1[0] * (p2[1] - p3[1]) +
                        p2[0] * (p3[1] - p1[1]) +
                        p3[0] * (p1[1] - p2[1])
                    );
                    
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        
        return maxArea;
    }
}
