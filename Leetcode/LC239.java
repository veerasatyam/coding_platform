import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        
        for (int i = 0; i < k; i++) {
            while (!q.isEmpty() && nums[i] > q.getLast()) {
                q.pollLast();
            }
            q.addLast(nums[i]);
        }
        result[0] = q.getFirst();
        int s = 1, e = k;
        while (e < nums.length) {
            if (nums[s - 1] == q.getFirst()) {
                q.pollFirst();
            }
            
            while (!q.isEmpty() && nums[e] > q.getLast()) {
                q.pollLast();
            }
            q.addLast(nums[e]);
            
            result[s] = q.getFirst();
            
            s++;
            e++;
        } 
        return result;
    }
}
