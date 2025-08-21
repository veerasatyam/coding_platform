class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), k = needle.length();
        if (k > n) return -1;
        for (int i = 0; i <= n - k; i++) {
            String x = haystack.substring(i, i + k);
            if (x.equals(needle)) return i;
        }
        return -1;
    }
}
