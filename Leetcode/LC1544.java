import java.util.Stack;

class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            
            if (!stack.isEmpty() && Math.abs(stack.peek() - x) == 32) {
                stack.pop();
            } else {
                stack.push(x);
            }
        }
        
        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        
        return str.reverse().toString();
    }
}

//without using stack
// class Solution {
//     public String makeGood(String s) {
//         StringBuilder stack = new StringBuilder();
        
//         for (char c : s.toCharArray()) {
//             int len = stack.length();
//             if (len > 0 && Math.abs(stack.charAt(len - 1) - c) == 32) {
//                 stack.deleteCharAt(len - 1); // Remove the bad pair
//             } else {
//                 stack.append(c);
//             }
//         }
        
//         return stack.toString();
//     }
// }