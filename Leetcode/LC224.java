class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0, sign = 1;
        int len = s.length(), i = 0;

        while (i < len) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int number = 0;  
                while (i < len && Character.isDigit(s.charAt(i))) {
                    number = (number * 10) + s.charAt(i) - '0';
                    i++;
                } 
                result += (sign * number);
                continue;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                int prevSign = stack.pop();
                int prevResult = stack.pop();
                result = (prevSign * result) + prevResult;
                sign = 1;
            }

            i++;
        }

        return result;
    }
}