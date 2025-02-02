// //first approach easy 
// import java.lang.reflect.Array;
// import java.util.ArrayList;
// import java.util.Arrays;

// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int i=m;
//         int j=0;
//         while(n-->0)
//         {
//           nums1[i]=nums2[j];
//           i++;
//           j++;
//         }
//         Arrays.sort(nums1);
//     }
// }



// second approach
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
