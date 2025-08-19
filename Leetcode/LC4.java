// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         int n = nums1.length, m = nums2.length;
//         int total = n + m;
//         int i = 0, j = 0;
//         int prev = 0, curr = 0;

//         for (int k = 0; k <= total / 2; k++) {
//             prev = curr;
//             if (i < n && (j >= m || nums1[i] <= nums2[j])) {
//                 curr = nums1[i];
//                 i++;
//             } else {
//                 curr = nums2[j];
//                 j++;
//             }
//         }

//         if (total % 2 == 1) {
//             return curr;
//         } else {
//             return (prev + curr) / 2.0;
//         }
//     }
// }

// optimal Solution 
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int n1 = nums1.length;
        int n2 = nums2.length;
        int low = 0, high = n1;
        int half = (n1 + n2 + 1) / 2;

        while (low <= high) {
            int i = (low + high) / 2;
            int j = half - i;

            int aleft = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int aright = (i == n1) ? Integer.MAX_VALUE : nums1[i];
            int bleft = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int bright = (j == n2) ? Integer.MAX_VALUE : nums2[j];

            if (aleft <= bright && bleft <= aright) {
                if ((n1 + n2) % 2 == 1) {
                    return Math.max(aleft, bleft);
                } else {
                    return (Math.max(aleft, bleft) + Math.min(aright, bright)) / 2.0;
                }
            } else if (aleft > bright) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }
        return 0.0;
    }
}
