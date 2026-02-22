class Solution {
    public boolean isDigitorialPermutation(int n) {
        int original = n;
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += factorial(digit);
            n /= 10;
        }
        return isPermutation(original, sum);
    }
    private int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    private boolean isPermutation(int a, int b) {
        char[] arr1 = String.valueOf(a).toCharArray();
        char[] arr2 = String.valueOf(b).toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}