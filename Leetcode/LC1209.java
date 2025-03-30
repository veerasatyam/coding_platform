// import java.util.Stack;

// class Solution {
//     public String removeDuplicates(String s, int k) {
//         Stack<Character> stack = new Stack<>();
//         Stack<Integer> counter = new Stack<>();
//         for(char x : s.toCharArray())
//         {
//             if(!stack.isEmpty() && stack.peek()==x)
//             {
//                 int a = counter.pop() + 1;
//                 counter.push(a);
//                 stack.push(x);
//             }
//             else{
//                 stack.push(x);
//                 counter.push(1);
//             }
//             if(counter.peek()==k)
//             {
//                 for(int i=0;i<k;i++) stack.pop();
//                 counter.pop();
//             }
//         }
//         StringBuilder str = new StringBuilder();
//         while(!stack.isEmpty())
//         {
//             str.append(stack.pop());
//         }
//         return str.reverse().toString();
//     }
// }

import java.util.Stack;

class Solution {
    class CharCount {
        char character;
        int count;

        CharCount(char character, int count) {
            this.character = character;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<CharCount> stack = new Stack<>();
        
        for (char x : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().character == x) {
                stack.peek().count++;
                
                if (stack.peek().count == k) {
                    stack.pop();
                }
            } else {
                stack.push(new CharCount(x, 1));
            }
        }

        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            CharCount top = stack.pop();
            for (int i = 0; i < top.count; i++) {
                str.append(top.character);
            }
        }

        return str.reverse().toString();
    }
}
