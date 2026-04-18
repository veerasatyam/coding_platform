class Solution {
    int maxOnes(int[] arr) {
        int ones = 0;
        for (int x : arr) {
            if (x == 1) ones++;
        }

        int maxGain = 0;
        int curr = 0;

        for (int x : arr) {
            int val = (x == 0) ? 1 : -1;
            curr = Math.max(val, curr + val);
            maxGain = Math.max(maxGain, curr);
        }

        return ones + maxGain;
    }
}