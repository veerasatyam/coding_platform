import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    static List<Integer> leftSmaller(int n, int a[]) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        
        for (int x : a) {
            while (!stack.isEmpty() && stack.peek() >= x) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result.add(-1);
            } else {
                result.add(stack.peek());
            }
            stack.push(x);
        }
        return result;
    }
}
