class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int a : nums){
            min = Math.min(min,findSum(a));
        }
        return min;
    }
    private int findSum(int n){
        int sum = 0;
        while(n != 0){
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
}