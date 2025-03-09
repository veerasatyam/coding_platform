class Solution {
    public int median(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int total = n * m;
        int k = (total + 1) / 2;
        int l = findMin(mat);
        int h = findMax(mat,m);

        while (l < h) {
            int mid = (l + h) / 2;
            int cnt = count(mat, mid);
            if (cnt < k) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }

    private int findMax(int[][] mat,int m) {
        int max = 0;
        for (int i = 0; i < mat.length; i++) {
            max = Math.max(max, mat[i][m - 1]);
        }
        return max;
    }

    private int findMin(int[][] mat) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < mat.length; i++) {
            min = Math.min(min, mat[i][0]);
        }
        return min;
    }

    private int count(int[][] mat, int target) {
        int c = 0;
        for (int i = 0; i < mat.length; i++) {
            c += countSmallerEqual(mat[i], target);
        }
        return c;
    }

    private int countSmallerEqual(int[] row, int target) {
        int l = 0, h = row.length - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (row[mid] <= target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return l;
    }
}