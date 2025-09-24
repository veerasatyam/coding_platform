class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (chars[i] != chars[j]) {
                if (chars[i] < chars[j]) {
                    chars[j] = chars[i];
                } else {
                    chars[i] = chars[j];
                }
            }
            i++;
            j--;
        }
        return new String(chars);
    }
}
