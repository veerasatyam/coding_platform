class Solution {
    public String removeUtil(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            char currentChar = s.charAt(i);
            int j = i;

            while (j + 1 < s.length() && s.charAt(j + 1) == currentChar) {
                j++;
            }

            if (i == j) {
                sb.append(currentChar);
            }

            i = j + 1;
        }

        String newStr = sb.toString();
        return (newStr.equals(s)) ? newStr : removeUtil(newStr);
    }
}