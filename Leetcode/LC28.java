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


import java.util.*;

class Solution {
    public int[] computeLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0;
        int i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public List<Integer> KMP(String text, String pattern) {
        int[] lps = computeLPS(pattern);
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if (j == pattern.length()) {
                result.add(i - j);
                j = lps[j - 1];
            }
            else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return result;
    }
}