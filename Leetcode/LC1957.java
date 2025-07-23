class Solution {
    public String makeFancyString(String s) {
        int fancy=1;
        StringBuilder str = new StringBuilder();
        int n = s.length();
        if(n<0) return s;
        str.append(s.charAt(0));
        for(int i=1;i<n;i++){
            char curr = s.charAt(i);
            char prev = s.charAt(i-1);
            if(curr==prev) fancy++;
            else fancy=1;
            if(fancy>2) continue;
            str.append(curr);
        }
        return str.toString();
    }
}