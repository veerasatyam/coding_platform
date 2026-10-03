class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == '(') stack.push(i);
            else{
                stack.pop();
                if(stack.isEmpty()) stack.push(i);
                else maxLen = Math.max(maxLen, i - stack.peek());
            }
        }
        return maxLen;
    }
}