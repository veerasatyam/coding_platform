import java.util.*;

class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(set);
        int size = Math.min(k, maxHeap.size());
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }
}