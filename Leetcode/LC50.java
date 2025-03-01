class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        
        long exp = n; 
        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }

        double t = myPow(x, (int) (exp / 2)); 
        return (exp % 2 == 0) ? t * t : t * t * x;
    }
}