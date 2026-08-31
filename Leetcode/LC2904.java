class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int i = 0;
        int j = 0;
        int n = s.length();
        int count = 0;
        String ans = "";
        while(j < n){
            char ch = s.charAt(j);
            if(ch == '1') count++;
            if(count == k){
                while(i <= j && count == k){
                    if(ans.equals("") || ans.length() > j - i + 1){
                        ans = s.substring(i, j + 1);
                    }else if(ans.length() == j - i + 1){
                        ans = ans.compareTo(s.substring(i, j + 1)) < 0 ? ans : s.substring(i, j + 1);
                    }
                    if(s.charAt(i) == '1') count--;
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
}