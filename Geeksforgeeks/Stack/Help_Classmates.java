import java.util.Stack;

class Solution {
    public static int[] help_classmate(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = arr[stack.peek()];
            }
            
            stack.push(i);
        }
        
        return result;
    }
}
