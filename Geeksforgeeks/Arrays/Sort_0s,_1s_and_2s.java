class Solution {
    public void sort012(int[] arr) {
        int n = arr.length;
        int x = n - 1;

        // First pass: Move all 2s to the end
        for (int i = 0; i <= x; i++) {
            while (x >= 0 && arr[x] == 2) {
                x--;
            }
            if (i > x) break;
            if (arr[i] == 2) {
                int temp = arr[i];
                arr[i] = arr[x];
                arr[x] = temp;
                x--;
            }
        }

        // Second pass: Move all 1s to the middle
        int nx = x;
        for (int i = 0; i <= nx; i++) {
            while (nx >= 0 && arr[nx] == 1) {
                nx--;
            }
            if (i > nx) break;
            if (arr[i] == 1) {
                int temp = arr[i];
                arr[i] = arr[nx];
                arr[nx] = temp;
                nx--;
            }
        }
    }
}