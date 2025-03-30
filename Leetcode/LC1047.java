class Solution {
    public String removeDuplicates(String s) {

        char[] cs = s.toCharArray();
        int n = cs.length;

        int top = 0;
        for(int i = 1; i < n; ++i){
            char c = cs[i];
            if(top != -1 && c == cs[top])
                top--;
            else
                cs[++top] = c;
        }
        
        return new String(cs, 0, top + 1);
    }
}