import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> hms = new HashMap<>();
        HashMap<Character, Character> hmt = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char S = s.charAt(i);
            char T = t.charAt(i);

            if (hms.containsKey(S)) {
                if (hms.get(S) != T) {
                    return false;
                }
            } else {
                hms.put(S, T);
            }

            if (hmt.containsKey(T)) {
                if (hmt.get(T) != S) {
                    return false;
                }
            } else {
                hmt.put(T, S);
            }
        }

        return true;
    }
}
