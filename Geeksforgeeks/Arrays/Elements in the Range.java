class Solution {
    public boolean checkElements(int start, int end, int[] arr) {
        boolean[] present = new boolean[end + 1];
        for (int num : arr) {
            if (num >= start && num <= end) {
                present[num] = true;
            }
        }
        for (int i = start; i <= end; i++) {
            if (!present[i]) {
                return false;
            }
        }
        return true;
    }
}