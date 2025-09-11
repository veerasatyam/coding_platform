class Solution {
    public int findPages(int[] arr, int k) {
        if (k > arr.length) return -1;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int a : arr) {
            max = Math.max(max, a);
            sum += a;
        }
        int res = -1;
        int low = max, high = sum;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(mid, arr, k)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    private boolean check(int limit, int[] arr, int k) {
        int students = 1;
        int sum = 0;
        for (int pages : arr) {
            if (sum + pages > limit) {
                students++;
                sum = pages;
                if (students > k) return false;
            } else {
                sum += pages;
            }
        }
        return true;
    }
}
