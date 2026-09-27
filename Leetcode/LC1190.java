class Solution {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        String curr = "";
        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(curr);
                curr = "";
            }else if(ch == ')'){
                curr = stack.pop() + new StringBuilder(curr).reverse();
            }else{
                curr += ch;
            }
        }
        return curr;
    }
}