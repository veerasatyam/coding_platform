import java.util.Stack;
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(char x : s.toCharArray()) {
            if (x == '(') stack.push(x);
            else if (x == ')' && !stack.isEmpty() && stack.peek() == '(') stack.pop();
            else count++;
        }
        while (!stack.isEmpty()) {
            stack.pop();
            count++;
        }
        return count;
    }
}


//without using stack
// class Solution {
//     public int minAddToMakeValid(String s) {
        // int left = 0, right = 0;
        
        // for (char c : s.toCharArray()) {
        //     if (c == '(') {
        //         left++; 
        //     } else {
        //         if (left > 0) {
        //             left--;
        //         } else {
        //             right++; 
        //         }
        //     }
        // }
        
        // return left + right;
//     }
// }