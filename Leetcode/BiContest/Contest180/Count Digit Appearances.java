class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int count = 0;
        for(int a : nums){
            count = count + find(digit,a);
        }
        return count;
    }
    private int find(int d,int nums){
        int count = 0;
        while(nums > 0){
           int digit = nums % 10;
            nums /= 10;
            if(digit == d) count++;
        }
        return count;
    }
}