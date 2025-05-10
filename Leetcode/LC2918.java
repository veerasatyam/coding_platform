class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int zc1 = 0, zc2 = 0;

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == 0) {
                nums1[i] = 1;
                zc1++;
            }
            sum1 += nums1[i];
        }

        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == 0) {
                nums2[i] = 1;
                zc2++;
            }
            sum2 += nums2[i];
        }

        if (sum1 == sum2) return sum1;
        if (sum1 > sum2 && zc2 != 0) return sum1;
        if (sum2 > sum1 && zc1 != 0) return sum2;

        return -1;
    }
}
