class Solution {
    static int inversionCount(int arr[]) {
        int[] temp = new int[arr.length];
        return mergeSort(arr, temp, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int[] temp, int start, int end) {
        if (start >= end) return 0;

        int mid = (start + end) / 2;
        int leftCount = mergeSort(arr, temp, start, mid);
        int rightCount = mergeSort(arr, temp, mid + 1, end);
        int mergeCount = merge(arr, temp, start, mid, end);

        return leftCount + rightCount + mergeCount;
    }

    private static int merge(int[] arr, int[] temp, int start, int mid, int end) {
        int i = start, j = mid + 1, k = start;
        int invCount = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid - i + 1);
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= end) temp[k++] = arr[j++];

        System.arraycopy(temp, start, arr, start, end - start + 1);

        return invCount;
    }
}
