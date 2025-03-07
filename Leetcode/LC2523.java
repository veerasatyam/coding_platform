class LC2523 {
    public int[] closestPrimes(int left, int right) {
        int MAX_N = 1000000;
        boolean[] isPrime = new boolean[MAX_N + 1];

        for (int i = 0; i <= MAX_N; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= MAX_N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX_N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int num = left; num <= right; num++) {
            if (isPrime[num]) {
                primes.add(num);
            }
        }

        if (primes.size() < 2) {
            return new int[]{-1, -1};
        }

        int minDiff = Integer.MAX_VALUE;
        int num1 = -1, num2 = -1;

        for (int i = 0; i < primes.size() - 1; i++) {
            int diff = primes.get(i + 1) - primes.get(i);
            if (diff < minDiff) {
                minDiff = diff;
                num1 = primes.get(i);
                num2 = primes.get(i + 1);
            }
        }

        return new int[]{num1, num2};
    }
}