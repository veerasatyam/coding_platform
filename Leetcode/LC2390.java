import java.util.Stack;

class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char a : s.toCharArray()) {
            if (a == '*') {
                stack.pop();
            } else {
                stack.push(a);
            }
        }

        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }

        return str.reverse().toString();
    }
}
