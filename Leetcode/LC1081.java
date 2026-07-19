class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        int[] lastIndex = new int[26];
        for (int i = 0;i<n;i++) {
            lastIndex[s.charAt(i)-'a']=i;
        }
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < n;i++){
            char c = s.charAt(i);
            if(visited[c-'a']) continue;
            while(!stack.isEmpty() && stack.peek() > c && lastIndex[stack.peek() - 'a'] > i) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visited[c-'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}