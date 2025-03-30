import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char x : s.toCharArray()) {
            if(x == '[' || x == '(' || x == '{') {
                st.push(x);
            } else if(x == ')' && !st.isEmpty() && st.peek() == '(') {
                st.pop();
            } else if(x == ']' && !st.isEmpty() && st.peek() == '[') {
                st.pop();
            } else if(x == '}' && !st.isEmpty() && st.peek() == '{') {
                st.pop();
            } else {
                return false;
            }
        }
        return st.isEmpty();
    }
}
