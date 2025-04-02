import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] invalid = new boolean[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    invalid[i] = true;
                }
            }
        }
        
        while (!stack.isEmpty()) {
            invalid[stack.pop()] = true;
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!invalid[i]) {
                result.append(s.charAt(i));
            }
        }
        
        return result.toString();
    }
}