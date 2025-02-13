import java.util.Stack;

class Solution {
    public String reverseOnlyLetters(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                stack.push(c);
            }
        }

        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                result.append(stack.pop());
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
