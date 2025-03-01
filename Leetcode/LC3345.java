class Solution {
    public int smallestNumber(int n, int t) {
        for (int i = n; i < Integer.MAX_VALUE; i++) {
            int x = findProduct(i);
            if (x % t == 0) return i;
        }
        return n;
    }

    public int findProduct(int a) {
        if (a == 0) return 1;
        int product = 1;
        while (a > 0) {
            int remainder = a % 10;
            product *= remainder;
            a /= 10;
        }
        return product;
    }
}
