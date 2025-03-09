class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        int l = matrix[0][0], r = matrix[n - 1][m - 1];
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (count(matrix, mid) >= k) { 
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private int count(int[][] matrix, int target) {
        int count = 0, n = matrix.length, j = matrix[0].length - 1;

        for (int i = 0; i < n; i++) {
            while (j >= 0 && matrix[i][j] > target) {
                j--;
            }
            count += (j + 1);
        }
        return count;
    }
}
