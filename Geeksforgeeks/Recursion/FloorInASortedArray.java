class Solution {
    static int findFloor(int[] arr, int k) {
        int l = 0, h = arr.length - 1;
        int index = -1;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (arr[mid] <= k) {
                index = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return index;
    }
}
