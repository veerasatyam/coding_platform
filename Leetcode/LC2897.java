class Solution {
    final int mod = 1000000007;
    public int maxSum(List<Integer> nums, int k) {
        int[] count = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    count[i]++;
                }
            }
        }
        long sum = 0;
        while (k-- > 0) {
            int number = 0;
            for (int i = 31; i >= 0; i--) {
                if (count[i] > 0) {
                    number |= (1 << i);
                    count[i]--;
                }
            }
            sum = (sum + (long) number * number % mod) % mod;
        }
        return (int) sum;
    }
}