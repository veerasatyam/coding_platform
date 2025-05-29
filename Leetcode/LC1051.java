class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] expected = new int[n];
        for (int i = 0; i < n; i++) {
            expected[i] = heights[i];
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (expected[j] > expected[j + 1]) {
                    int temp = expected[j];
                    expected[j] = expected[j + 1];
                    expected[j + 1] = temp;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        return count;
    }
}