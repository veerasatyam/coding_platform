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

// index jumping approach
class Solution {
    public String reverseParentheses(String s) {
        HashMap<Integer, Integer> pair = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0, j = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else if(s.charAt(i) == ')'){
                j = stack.pop();
                pair.put(i, j);
                pair.put(j, i);
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int d = 1;
        while(i < s.length()){
            if(s.charAt(i) == '(' || s.charAt(i) == ')'){
                i = pair.get(i);
                d = -d;
            }else{
                sb.append(s.charAt(i));
            }
            i += d;
        }
        return sb.toString();
    }
}