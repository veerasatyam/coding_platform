class Solution {
    public int calculate(String s) {
        int num = 0;
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        char sign = '+';

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == n - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }
        int result = 0;
        for (int val : stack) {
            result += val;
        }
        return result;
    }
}
