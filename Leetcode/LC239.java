import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q_indices = new LinkedList<>();
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for(int i = 0;i < n; i++){
            if(!q_indices.isEmpty() && q_indices.getFirst() <= i - k) q_indices.pollFirst();
            while (!q_indices.isEmpty() && nums[q_indices.getLast()] < nums[i]) q_indices.pollLast();
            q_indices.addLast(i);
            if(i >= k - 1){
                ans[i] = nums[q_indices.getFirst()];
            }
        }
        return ans;
    }
}


// bruteforce approach 
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(k > n) return new int[]{-1};
        int[] ans = new int[n - k + 1];
        for(int i = 0; i <= n - k; i++){
            int max = nums[i];
            for(int j = i; j < i + k; j++){
                max = Math.max(max,nums[j]);
            }
            ans[i] = max;
        }
        return ans;
    }
}