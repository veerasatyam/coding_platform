class Solution {
    public int sumOfPrimesInRange(int n) {
        boolean[] primes = new boolean[1001];
        findPrimes(primes);
        int r = reverse(n);
        int sum = 0;
        for(int i = Math.min(n,r);i<=Math.max(n,r);i++){
            if(primes[i]) sum = sum + i;
        }
        return sum;
    }
    private void findPrimes(boolean[] primes){
        Arrays.fill(primes,true);
        primes[0] = primes[1] = false;
        for(int i = 2;i<primes.length;i++){
            for(int j = i*i;j<=1000;j += i){
                primes[j] = false;
            }
        }
    }
    private int reverse(int n){
        int result = 0;
        while(n > 0){
            int digit = n % 10;
            result = result * 10 + digit;
            n =n / 10;
        }
        return result;
    }
}