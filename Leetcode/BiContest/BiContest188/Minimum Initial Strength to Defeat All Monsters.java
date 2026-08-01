class Solution {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        int n = monsters.length;
        long[] diff = new long[n + 1];
        for(int[] b : boosts){
            int l = b[0] , r = b[1];
            long v = b[2];
            diff[l] += v;
            diff[r + 1] -= v;
        }
        long[] bonus = new long[n];
        long running = 0;
        for(int i = 0; i < n; i++){
            running += diff[i];
            bonus[i] = running;
        }
        long low = 0;
        long high = 0;
        for(int m : monsters){
            high += m;
        }
        while(low < high){
            long mid = low + (high - low) / 2;
            if(canDefeatAll(mid,monsters,bonus)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    private boolean canDefeatAll(long initial, int[] monsters, long[] bonus) {
        long strength = initial;
        for (int i = 0;i < monsters.length;i++) {
            if (strength + bonus[i] < monsters[i]) {
                return false;
            }
            strength -= monsters[i];
            if (strength < 0) strength = 0;
        }
        return true;
    }
}