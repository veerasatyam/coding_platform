class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
        int ans = 0;
        int pow = 0;
        while(n>0){
            if((n & 1) == 0){
                ans = ans  +(int)Math.pow(2,pow);
            }
            pow++;
            n = n >> 1;
        }
        return ans;
    }
}