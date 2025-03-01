class Solution {
    public void reverseArray(int arr[]) {
        reverseHelper(arr, 0, arr.length - 1);
    }

    private void reverseHelper(int arr[], int left, int right) {
        if (left >= right) return; 

        swap(arr, left, right);

        reverseHelper(arr, left + 1, right - 1);
    }

    private void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}