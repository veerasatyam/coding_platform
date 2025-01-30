class Solution {
    public int firstUniqChar(String s) {
        int a = -1;
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (i == s.lastIndexOf(x) && s.indexOf(x) == i) {
                a = i;
                break;
            }
        }
        return a;
    }
}
