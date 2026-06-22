// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
//         for (int num : nums) {
//             min = Math.min(min, num);
//             max = Math.max(max, num);
//         }

//         int l = min, h = max, ans = min;
        
//         while (l <= h) {
//             int mid = l + (h - l) / 2;
            
//             if (countGreaterOrEqual(nums, mid) >= k) {
//                 ans = mid;
//                 l = mid + 1;
//             } else {
//                 h = mid - 1;
//             }
//         }
        
//         return ans;
//     }

//     private int countGreaterOrEqual(int[] nums, int mid) {
//         int count = 0;
//         for (int num : nums) {
//             if (num >= mid) count++;
//         }
//         return count;
//     }
// }

//using heaps

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for (int num : nums) {
            minheap.add(num);
            if (minheap.size() > k) {
                minheap.poll();
            }
        }
        return minheap.peek();
    }
}


// Quick Selct

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int pivot = partition(nums, left, right);
            if (pivot == k - 1) return nums[pivot];
            else if (pivot > k - 1) right = pivot - 1;
            else left = pivot + 1;
        }
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        int i = l + 1;
        int j = r;
        while (i <= j) {
            while (i <= j && nums[i] >= pivot) i++;
            while (i <= j && nums[j] < pivot) j--;
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[l];
        nums[l] = nums[j];
        nums[j] = temp;
        return j;
    }
}