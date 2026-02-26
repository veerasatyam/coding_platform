class Solution {
    public int reverse(int n) {
        long res = 0;
        long x = n;
        while(x != 0) {
            int pop = (int)(x % 10);
            x /= 10;
            res = res * 10 + pop;
        }
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        return (int)res;
    }
}