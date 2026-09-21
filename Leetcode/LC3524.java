class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        int n = nums.length;
        int product = 1;
        for(int i = 0; i < n; i++){
            product = 1;
            for(int j = i; j < n; j++){
                product = (int)(((long) product * nums[j]) % k);
                result[product]++;
            }
        }
        return result;
    }
}


// optimal solution
class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[] result = new long[k];
        long[] prevCount = new long[k];

        for (int i = 0; i < n; i++) {
            long[] currCount = new long[k];
            int currElementRemainder = ((nums[i] % k) + k) % k;
            currCount[currElementRemainder]++;
            for (int oldRem = 0; oldRem < k; oldRem++) {
                int newRem = (int) (((long) oldRem * nums[i]) % k);
                if (newRem < 0) {
                    newRem += k;
                }
                currCount[newRem] += prevCount[oldRem];
            }
            prevCount = currCount;
            for (int x = 0; x < k; x++) {
                result[x] += prevCount[x];
            }
        }
        return result;
    }
}
