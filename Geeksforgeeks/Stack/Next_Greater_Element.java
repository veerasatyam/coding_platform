import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                result.add(-1);
            } else {
                result.add(stack.peek());
            }
            
            stack.push(arr[i]);
        }

        ArrayList<Integer> reversedResult = new ArrayList<>();
        for (int i = result.size() - 1; i >= 0; i--) {
            reversedResult.add(result.get(i));
        }

        return reversedResult;
    }
}
