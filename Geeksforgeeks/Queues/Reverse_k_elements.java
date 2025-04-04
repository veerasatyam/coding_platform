import java.util.Queue;
import java.util.Stack;

class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        if (q == null || q.isEmpty() || k <= 0) {
            return q;
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < k; i++) {
            stack.push(q.poll());
        }
        
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
        
        int remaining = q.size() - k;
        for (int i = 0; i < remaining; i++) {
            q.add(q.poll());
        }
        
        return q;
    }
}