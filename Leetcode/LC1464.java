import java.util.PriorityQueue;

class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int a : nums) heap.add(-a);
        return (-heap.poll()-1)*(-heap.poll()-1);
    }
}


// class Solution {
//     public int maxProduct(int[] nums) {
//         int n = nums.length, max = Integer.MIN_VALUE, secmax = Integer.MIN_VALUE;
//         for(int i=0;i<nums.length;i++) {
//             if(nums[i]>max) {
//                 secmax = max;
//                 max = nums[i];
//             } 
//             else if(nums[i]>secmax)
//                 secmax = nums[i];
//         }
//         return (max-1)*(secmax-1);
//     }
// }