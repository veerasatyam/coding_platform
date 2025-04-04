import java.util.Stack;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastocc = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            lastocc[x - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] used = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (used[x - 'a']) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > x && lastocc[stack.peek() - 'a'] > i) {
                used[stack.pop() - 'a'] = false;
            }

            stack.push(x);
            used[x - 'a'] = true;
        }

        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }

        return str.reverse().toString();
    }
}
