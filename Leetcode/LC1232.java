class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates[1][0] == coordinates[0][0]) {
            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[i][0] != coordinates[0][0]) {
                    return false;
                }
            }
        } else {
            float slope = (float)(coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
            for (int i = 2; i < coordinates.length; i++) {
                int x1 = coordinates[0][0];
                int y1 = coordinates[0][1];
                int x2 = coordinates[i][0];
                int y2 = coordinates[i][1];
                
                if (x2 - x1 == 0) {
                    if (slope != Float.POSITIVE_INFINITY) {
                        return false;
                    }
                } else {
                    float currentSlope = (float)(y2 - y1) / (x2 - x1);
                    if (Math.abs(currentSlope - slope) > 1e-6) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
