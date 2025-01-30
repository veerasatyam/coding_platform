class Solution {
    public void reverseString(char[] s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s) {
            sb.append(c);
        }
        sb.reverse();
        for (int i = 0; i < s.length; i++) {
            s[i] = sb.charAt(i);
        }
    }
}
