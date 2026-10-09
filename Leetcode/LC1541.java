class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char x = s.charAt(i);
            if (x == '(') {
                stack.push(x);
            } else {
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    ans++; 
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    ans++;
                }
            }
        }
        ans += stack.size() * 2;
        return ans;
    }
}

// using without stack
class Solution{
    public int minInsertions(String s){
        int n = s.length();
        int ans = 0;
        int open = 0;
        for(int i = 0; i < n; i++){
            char x = s.charAt(i);
            if(x == '('){
                open++;
            }
            else{
                if(i + 1 < n && s.charAt(i + 1) == ')') i++;
                else  ans++;
                if(open > 0) open--;
                else  ans++;
            }
        }
            ans += open * 2;
            return ans;
    }
}