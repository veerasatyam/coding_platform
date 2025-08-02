// public class Solution {
//     public int[] dailyTemperatures(int[] temperatures) {
//         int n = temperatures.length;
//         int[] res = new int[n];
//         Stack<Integer> stack = new Stack<>();

//         for (int i = n - 1; i >= 0; i--) {
//             while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
//                 stack.pop();
//             }
//             if (!stack.isEmpty()) {
//                 res[i] = stack.peek() - i;
//             }

//             stack.push(i);
//         }

//         return res;
//     }
// }


class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
         int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
          
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return answer;
    }
}