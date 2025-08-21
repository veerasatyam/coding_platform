import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (char x : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > x) {
                stack.pop();
                k--;
            }
            stack.push(x);
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) str.append(stack.pop());
        str.reverse();
        while (str.length() > 0 && str.charAt(0) == '0') str.deleteCharAt(0);
        return str.length() == 0 ? "0" : str.toString();
    }
}
