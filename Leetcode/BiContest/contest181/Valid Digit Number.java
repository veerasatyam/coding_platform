class Solution {
    public boolean validDigit(int n, int x) {
        return check(n,x);
    }
    private boolean check(int n,int x){
        int c= 0;
        int rem = -1;
        while(n > 0){
            rem = n % 10;
            if(rem == x) c++;
            n = n/10;
        }
        return c >= 1 && rem != x;
    }
}