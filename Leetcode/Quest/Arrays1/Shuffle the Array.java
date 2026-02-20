class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        int i = 0, j = n, k = 0;
        while (i < n && j < 2 * n) {
            res[k++] = nums[i++];
            res[k++] = nums[j++];
        }
        return res;
    }
}
