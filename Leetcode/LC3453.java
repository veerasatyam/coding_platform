class Solution {
    public double separateSquares(int[][] squares) {
        double left = Double.MAX_VALUE;
        double right = Double.MIN_VALUE;
        double totalArea = 0.0;
        for(int[] s : squares){
            double y = s[1];
            double side = s[2];
            left = Math.min(left,y);
            right = Math.max(right,y+side);
            totalArea += side*side;
        }
        double targetArea = totalArea/2.0;
        while(left <= right){
            double mid = left + (right - left)/2.0;
            double areabelow = 0.0;
            for(int[] s : squares){
                double y = s[1];
                double side = s[2];
                if(y+side <= mid){
                    areabelow += side*side;
                } else if(y < mid){
                    areabelow += (mid-y)*side;
                }
            }
            if(areabelow >= targetArea){
                right = mid - 0.000001;
            } else {
                left = mid + 0.000001;
            }
        }
        return left;
    }
}