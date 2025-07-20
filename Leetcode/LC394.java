import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> number = new Stack<>();
        Stack<StringBuilder> string = new Stack<>();
        StringBuilder str = new StringBuilder();
        int k = 0;

        for (char x : s.toCharArray()) {
            if (Character.isDigit(x)) {
                k = k * 10 + (x - '0');
            } else if (x == '[') {
                number.push(k);
                string.push(str);
                str = new StringBuilder();
                k = 0;
            } else if (x == ']') {
                int repeat = number.pop();
                StringBuilder prev = string.pop();
                for (int i = 0; i < repeat; i++) {
                    prev.append(str);
                }
                str = prev;
            } else {
                str.append(x);
            }
        }

        return str.toString();
    }
}
