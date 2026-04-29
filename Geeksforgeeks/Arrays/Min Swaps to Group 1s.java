class Solution {
    public int minSwaps(int[] arr) {
        int count_ones = 0;
        int n = arr.length;
        for (int a : arr) {
            if (a == 1) count_ones++;
        }
        if (count_ones == 0) return -1;
        int MinOper = Integer.MAX_VALUE;
        for (int i = 0; i <=n - count_ones;i++) {
            int ones = 0;
            for (int j = i; j < i + count_ones; j++) {
                if (arr[j] == 1) ones++;
            }
            MinOper = Math.min(MinOper, count_ones - ones);
        }
        return MinOper;
    }
}

// optimal solution
class Solution {
    public int minSwaps(int[] arr) {
        int count_ones = 0;
        int n = arr.length;
        for (int a : arr) {
            if (a == 1) count_ones++;
        }
        if (count_ones == 0) return -1;
        int currOnes = 0;
        for (int i = 0; i < count_ones; i++) {
            if (arr[i] == 1) currOnes++;
        }
        int maxOnes = currOnes;
        for (int i = count_ones;i<arr.length;i++) {
            if (arr[i] == 1) currOnes++;
            if (arr[i - count_ones] == 1) currOnes--;
            maxOnes = Math.max(maxOnes, currOnes);
        }
        return count_ones - maxOnes;
    }
}