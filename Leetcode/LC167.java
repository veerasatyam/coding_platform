// class Solution {
//     public int[] twoSum(int[] numbers, int target) {
//         int n = numbers.length;

//         for (int i = 0; i < n; i++) {
//             int k = target - numbers[i];
//             int j = binarySearch(i + 1, n - 1, numbers, k);
//             if (j != -1) {
//                 return new int[]{i + 1, j + 1};
//             }
//         }
//         return new int[]{-1, -1};
//     }

//     private int binarySearch(int l, int r, int[] numbers, int k) {
//         while (l <= r) {
//             int mid = l + (r - l) / 2;
//             if (numbers[mid] == k) return mid;
//             else if (numbers[mid] > k) r = mid - 1;
//             else l = mid + 1;
//         }
//         return -1;
//     }
// }


class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) return new int[]{i + 1, j + 1};
            else if (sum < target) i++;
            else j--;
        }
        return new int[]{-1, -1};
    }
}
