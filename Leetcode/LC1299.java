class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        int maxRight = -1;

        for (int i = n - 1; i >= 0; i--) {
            result[i] = maxRight;
            maxRight = Math.max(maxRight, arr[i]);
        }
        return result;
    }
}
