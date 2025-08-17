class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int n = s.length();
        int start = 0, end = 0;

        for (int i = 0; i < n; i++) {
            // odd-length palindrome
            int left = i, right = i;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left > end - start) {
                    start = left;
                    end = right;
                }
                left--;
                right++;
            }

            // even-length palindrome
            left = i;
            right = i + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left > end - start) {
                    start = left;
                    end = right;
                }
                left--;
                right++;
            }
        }
        return s.substring(start, end + 1);
    }
}
