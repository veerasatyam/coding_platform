class Solution {
    public String longestCommonPrefix(String[] strs) {
         if (strs.length == 0) {
            return "";
        }
        String result = "";
        int j = 0;

        for (char a : strs[0].toCharArray()) {
            for (int i = 1; i < strs.length; i++) {
                if (j >= strs[i].length() || strs[i].charAt(j) != a) {
                    return result;
                }
            }
            result += a;
            j++;
        }
        return result;
    }
}
