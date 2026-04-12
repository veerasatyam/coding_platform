class Solution {
    public double[] internalAngles(int[] sides) {
        int a = sides[0];
        int b = sides[1];
        int c = sides[2];
        if(a + b <= c || b + c <= a || c + a <= b) return new double[]{};
        double A = Math.toDegrees(Math.acos((b * b + c * c - a * a) / (2.0 * b * c)));
        double B = Math.toDegrees(Math.acos((a * a + c * c - b * b) / (2.0 * a * c)));
        double C = Math.toDegrees(Math.acos((a * a + b * b - c * c) / (2.0 * a * b)));
        double[] result = new double[]{A, B, C};
        Arrays.sort(result);
        return result;
    }
}