class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        int n = 31;
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        for(int i = left;i<=right;i++){
            int x = countbits(i);
            boolean isprime = prime[x];
            if(isprime) count++;
        }
        return count;
    }
    private int countbits(int n){
        int result = 0;
        int x = n;
        while(x>0){
            result = result + (x & 1);
            x = x>>1;
        }
        return result;
    }
}