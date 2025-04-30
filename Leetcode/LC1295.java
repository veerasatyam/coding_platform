class Solution {
    public int findNumbers(int[] nums) {
         int count = 0;
        for (int num : nums) {
            if (numDigits(num) % 2 == 0) {
                count++;
            }
        }
        return count;
    }
    private static int numDigits(int num) {
        int digits = 0;
        while (num > 0) {
            num /= 10;
            digits++;
        }
        return digits;
    }
}