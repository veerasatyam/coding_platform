class Solution {
    public int findGCD(int[] nums) {
        int min = nums[0]; 
        int max = nums[0];  

        for (int a : nums) {
            max = Math.max(max, a);
            min = Math.min(min, a);
        }

        return gcd(max, min);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
