class GfG {
    public static boolean isPower(int x, int y) {
        if (x == 1)
            return (y == 1);
        if (y == 1)
            return true;
        int pow = x, i = 1;
        while (pow < y) {
            pow *= pow;
            i *= 2;
        }
        if (pow == y)
            return true;
        int low = x, high = pow;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int exponent = (int)(Math.log(mid) / Math.log(x));
            int result = (int)Math.pow(x, exponent);

            if (result == y)
                return true;
            if (result < y)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}