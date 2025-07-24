// import java.util.Stack;

// class Solution {
//     public int maximumGain(String s, int x, int y) {
//         int vab = x, vba = y;
//         int score = 0;
//         Stack<Character> stack = new Stack<>();

//         for (char element : s.toCharArray()) {
//             if (!stack.isEmpty()) {
//                 char top = stack.peek();
//                 String str = "" + top + element;

//                 if (str.equals("ab") && vab >= vba) {
//                     score += vab;
//                     stack.pop();
//                     continue; 
//                 } else if (str.equals("ba") && vba >= vab) {
//                     score += vba;
//                     stack.pop(); 
//                     continue;
//                 }
//             }
//             stack.push(element);
//         }
//         Stack<Character> remaining = new Stack<>();
//         while (!stack.isEmpty()) {
//             char curr = stack.pop();
//             if (!remaining.isEmpty()) {
//                 char top = remaining.peek();
//                 String str = "" + curr + top;

//                 if (str.equals("ab")) {
//                     score += vab;
//                     remaining.pop();
//                     continue;
//                 } else if (str.equals("ba")) {
//                     score += vba;
//                     remaining.pop();
//                     continue;
//                 }
//             }
//             remaining.push(curr);
//         }

//         return score;
//     }
// }


import java.util.Stack;

class Solution {
    public int maximumGain(String s, int x, int y) {
        int totalScore = 0;
        String highPriorityPair = x > y ? "ab" : "ba";
        String lowPriorityPair = x > y ? "ba" : "ab";
        int highPriorityScore = Math.max(x, y);
        int lowPriorityScore = Math.min(x, y);
        StringBuilder remainingAfterHigh = new StringBuilder();
        Stack<Character> stack1 = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == highPriorityPair.charAt(1) && !stack1.isEmpty() && stack1.peek() == highPriorityPair.charAt(0)) {
                stack1.pop();
                totalScore += highPriorityScore;
            } else {
                stack1.push(c);
            }
        }
        while(!stack1.isEmpty()){
            remainingAfterHigh.append(stack1.pop());
        }
        remainingAfterHigh.reverse();

        Stack<Character> stack2 = new Stack<>();
        for (char c : remainingAfterHigh.toString().toCharArray()) {
            if (c == lowPriorityPair.charAt(1) && !stack2.isEmpty() && stack2.peek() == lowPriorityPair.charAt(0)) {
                stack2.pop();
                totalScore += lowPriorityScore;
            } else {
                stack2.push(c);
            }
        }

        return totalScore;
    }
}