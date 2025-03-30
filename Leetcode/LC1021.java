import java.util.Stack;

class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder str = new StringBuilder();
        
        for (char x : s.toCharArray()) {
            if (x == '(') {
                if (!stack.isEmpty()) {
                    str.append(x);
                }
                stack.push(x);
            } else if (x == ')') {
                stack.pop();
                if (!stack.isEmpty()) {
                    str.append(x);
                }
            }
        }
        
        return str.toString();
    }
}


// class Solution {
//     public String removeOuterParentheses(String s) {
      
      
//     StringBuilder str = new StringBuilder();
//     int count = 0;

//     for(char c: s.toCharArray()){
//        if(c == ')') count--;
//        if(count > 0) str.append(c);
//        if(c == '(') count++;
//     }
//     return str.toString();
//     }
// }