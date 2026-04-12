class Solution {
    public int minOperations(int[] nums) {
        boolean[] isPrime = new boolean[1000001];
        markPrime(isPrime);
        int[] nextPrime = new int[1000001];
        int next = -1;
        for (int i = 1000000;i>=0;i--) {
            if (isPrime[i]) next = i;
            nextPrime[i] = next;
        }
        int min = 0;
        for (int i = 0;i<nums.length;i++) {
            if (i % 2 == 0){
                if (!isPrime[nums[i]]) {
                    int np = nextPrime[nums[i]];
                    min += (np - nums[i]);
                }
            } else {
                if (isPrime[nums[i]]) {
                    int val = nums[i];
                    while (isPrime[val]) {
                        val++;
                        min++;
                    }
                }
            }
        }
        return min;
    }
    private void markPrime(boolean[] prime) {
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2;i*i<prime.length;i++) {
            if (prime[i]){
                for (int j = i*i;j<prime.length;j += i) prime[j] = false;
            }
        }
    }
}