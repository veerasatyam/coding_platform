class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int count = 0;
        for (int i = 0;i < nums.length;i++) {
            long sum = 0;
            for (int j = i;j < nums.length;j++) {
                sum = sum + nums[j];
                if (isValid(sum, x)) count++;
            }
        }
        return count;
    }

    private boolean isValid(long sum,int x){
        if (sum == 0) return (0 == x && 0 == x);
        long tempSum = sum;
        int first = -1;
        int last = -1;
        last = (int)(tempSum % 10);
        while (tempSum >= 10)tempSum = tempSum / 10;
        first = (int)tempSum;
        return (first == x && last == x);
    }
}