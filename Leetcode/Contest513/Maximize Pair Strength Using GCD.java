class Solution {
    public long maxPairStrength(int[] nums) {
        long Strength = 0;
        int n = nums.length;
        for(int i = 0; i < n;i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                long g = gcd((long)nums[i],(long)nums[j]);
                long product = 1L * nums[i] * nums[j];
                long s = product / (g * g);
                Strength = Math.max(s,Strength);
            }
        }
        return Strength;
    }
    private long gcd(long a,long b){
        if(b == 0) return a;
        return gcd(b,a%b);
    }
}