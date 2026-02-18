class Solution {
    public boolean hasAlternatingBits(int n) {
        int x = n;
        int prev = -1;
        while(x>0){
            int r = (x & 1);
            if(r==prev) return false;
            prev = r;
            x = x>>1;
        }
        return true;
    }
}