class Solution {
    public static long distinctColoring(int N, int[] r, int[] g, int[] b) {
        long red = r[0], green = g[0], blue = b[0];

        for (int i = 1; i < N; i++) {
            long newRed = r[i] + Math.min(green, blue);
            long newGreen = g[i] + Math.min(red, blue);
            long newBlue = b[i] + Math.min(red, green);

            red = newRed;
            green = newGreen;
            blue = newBlue;
        }

        return Math.min(red, Math.min(green, blue));
    }
}
