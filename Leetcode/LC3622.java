class Solution {
    public boolean checkDivisibility(int n) {
        int[] result = helper(n);
        if(n % (result[0]  + result[1]) == 0) return true;
        return false;
    }
    private static int[] helper(int n){
        int p = 1;
        int s = 0;
        while(n != 0){
            int digit = n % 10;
            p = p * digit;
            s = s + digit;
            n = n  / 10;
        }
        return new int[]{p,s};
    }
}