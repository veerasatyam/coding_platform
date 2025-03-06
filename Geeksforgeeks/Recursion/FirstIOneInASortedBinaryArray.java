class Solution {
    public int firstIndex(int arr[]) {
        int l = 0, h = arr.length - 1;
        int index = -1;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (arr[mid] == 1) {
                index = mid;
                h = mid - 1;
            } else {
                l = mid + 1; 
            }
        }
        return index;
    }
}