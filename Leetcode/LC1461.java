// brute force, generate all possible codes and check if they are in the string but TLE
class Solution {
    HashSet<String> allCodes = new HashSet<>();
    public boolean hasAllCodes(String s, int k) {
        generate("", k);
        for (String code : allCodes) {
            if (!s.contains(code)) {
                return false;
            }
        }
        return true;
    }
    private void generate(String curr, int k) {
        if (k == 0) {
            allCodes.add(curr);
            return;
        }
        generate(curr + "0", k - 1);
        generate(curr + "1", k - 1);
    }
}

// optimized solution using a sliding window and a hash set to track seen codes
class Solution {
    public boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        if (s.length() < k) return false;
        HashSet<String> st = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);
            st.add(sub);   
            if (st.size() == need) {
                return true;
            }
        }
        return false;
    }
}