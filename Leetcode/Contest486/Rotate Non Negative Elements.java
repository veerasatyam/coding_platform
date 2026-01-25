class Solution {
    public int[] rotateElements(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result,Integer.MAX_VALUE);
        int count_neg = 0;
        for (int i =0;i<n;i++) {
            if (nums[i]<0) {
                result[i] = nums[i];
                count_neg++;
            }
        }
        int count_non_neg = n-count_neg;
        int[] non_neg_elements = new int[count_non_neg];
        for (int i = 0,j=0;i<n;i++) {
            if (nums[i] >= 0) {
                non_neg_elements[j++] = nums[i];
            }
        }
        int nn = non_neg_elements.length;
        if (nn == 0) return nums;
        k = k % nn;
        int[] result_n = new int[nn];
        for (int i = 0;i<nn;i++) {
            int index = (i - k + nn) % nn;
            result_n[index] = non_neg_elements[i];
        }
        int i = 0;
        for (int j = 0;j<n;j++) {
            if (result[j] == Integer.MAX_VALUE) {
                result[j] = result_n[i++];
            }
        }

        return result;
    }
}
