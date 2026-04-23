class Solution {
    public boolean canSplit(int arr[]) {
        int total = 0;
        for (int x : arr) total += x;
        int prefix = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            prefix += arr[i];
            if (prefix == total - prefix) {
                return true;
            }
        }
        return false;
    }
}