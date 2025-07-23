class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String str = "";
        int n = Math.min(str1.length(), str2.length());
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                str += str1.charAt(i);
                int x = str1.length() / str.length();
                int y = str2.length() / str.length();
                if (str.repeat(x).equals(str1) && str.repeat(y).equals(str2)) {
                    return str;
                }
            } else {
                break;
            }
        }
        return "";
    }
}
