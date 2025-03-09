package BinarySearch;

class Solution {
    public static int kthSmallest(int[] arr, int k) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int l = min, h = max, ans = min;
        
        while (l <= h) {
            int mid = l + (h - l) / 2;
            
            if (countLessOrEqual(arr, mid) >= k) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return ans;
    }

    private static int countLessOrEqual(int[] arr, int mid) {
        int count = 0;
        for (int num : arr) {
            if (num <= mid) count++;
        }
        return count;
    }
}
