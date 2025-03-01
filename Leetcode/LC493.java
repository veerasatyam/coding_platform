class Solution {
    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        return mergeSort(nums, temp, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int[] temp, int start, int end) {
        if (start >= end) return 0;

        int mid = start + (end - start) / 2;
        int leftCount = mergeSort(nums, temp, start, mid);
        int rightCount = mergeSort(nums, temp, mid + 1, end);
        int mergeCount = countReversePairs(nums, start, mid, end) + merge(nums, temp, start, mid, end);

        return leftCount + rightCount + mergeCount;
    }

    private int countReversePairs(int[] nums, int start, int mid, int end) {
        int count = 0, j = mid + 1;
        for (int i = start; i <= mid; i++) {
            while (j <= end && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }
        return count;
    }

    private int merge(int[] nums, int[] temp, int start, int mid, int end) {
        int i = start, j = mid + 1, k = start;
        
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= end) temp[k++] = nums[j++];

        System.arraycopy(temp, start, nums, start, end - start + 1);
        return 0;
    }
}
