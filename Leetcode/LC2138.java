class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = (int) Math.ceil((double) s.length() / k);
        String[] ans = new String[n];
        for (int i = 0, idx = 0; i < s.length(); i += k, idx++) {
            StringBuilder str = new StringBuilder();

            if (i + k <= s.length()) {
                str.append(s.substring(i, i + k));
            } else {
                str.append(s.substring(i));
                while (str.length() < k) {
                    str.append(fill);
                }
            }
            ans[idx] = str.toString();
        }
        return ans;
    }
}
