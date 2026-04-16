class Solution {
    public int myAtoi(String s) {
       int idx = 0;
       int sign = 1;
       int res= 0;
       int n = s.length();
       while(idx < n && s.charAt(idx) == ' ') idx++;
       while (idx < n && s.charAt(idx) == '+' || s.charAt(idx) == '-') {
         if(s.charAt(idx) == '-') sign = -1;
         idx++;
       }
       while (idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
            if (res > Integer.MAX_VALUE / 10 ||(res == Integer.MAX_VALUE / 10 && s.charAt(idx) - '0' > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = 10 * res + (s.charAt(idx++) - '0');
        }
        return res * sign;
    }
}