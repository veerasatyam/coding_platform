class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if (n == 0) return word2;
        if (m == 0) return word1;

        int i = 0, j = 0;
        StringBuilder res = new StringBuilder();

        while (i < n || j < m) {
            if (i < n) {
                res.append(word1.charAt(i));
                i++;
            }
            if (j < m) {
                res.append(word2.charAt(j));
                j++;
            }
        }

        return res.toString();
    }
}
