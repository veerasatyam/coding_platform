class Solution {
    public int kthElement(int a[], int b[], int k) {
        int l = Math.min(findMin(a), findMin(b));
        int h = Math.max(findMax(a), findMax(b));
        int ans = -1;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            int c = count(a, mid) + count(b, mid);

            if (c >= k) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private int findMax(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int x : arr) {
            max = Math.max(max, x);
        }
        return max;
    }

    private int findMin(int arr[]) {
        int min = Integer.MAX_VALUE;
        for (int x : arr) {
            min = Math.min(min, x);
        }
        return min;
    }

    private int count(int[] arr, int mid) {
        int count = 0;
        for (int num : arr) {
            if (num <= mid) count++;
        }
        return count;
    }
}
